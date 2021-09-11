package com.example.kotlimn

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.kotlimn.POJO.CoinPriceInfo
import com.example.kotlimn.POJO.CoinPriceInfoRawData
import com.example.kotlimn.api.ApiFactory
import com.example.kotlimn.database.AppDatabase
import com.google.gson.Gson
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CoinViewModel(application: Application) : AndroidViewModel(application) {
    private val db = AppDatabase.getInstance(application)
    private val compositeDisposable = CompositeDisposable()
    val priceList = db.coinPriceInfoDao().getPriceList()

    init {
        loadData()
    }

    fun getDetailInfo(fSym: String): LiveData<CoinPriceInfo> {
        return db.coinPriceInfoDao().getPriceInfoAboutCoin(fSym)
    }


    private fun loadData() {
        val disposable = ApiFactory.apiService.getTopCoinsInfo(limit = 50)
                .map { it.data?.map { it.coinInfo?.name }?.joinToString(",")}
                .flatMap { ApiFactory.apiService.getFullPriceList(fSyms = it) }
                .map { getPriceListFromRowData(it) }
                .delaySubscription(10, TimeUnit.SECONDS)
                .repeat()
                .retry()
                .subscribeOn(Schedulers.io())
                .subscribe({
                    db.coinPriceInfoDao().insertPriceList(it)
                    Log.d("Test_Of_Loading_Date", "Success:$it")
                },
                        {
                            Log.d("Test_Of_Loading_Date", "Failure:" + it.message)

                        })
        compositeDisposable.add(disposable)
    }

    private fun getPriceListFromRowData(coinPriceInfoRawData: CoinPriceInfoRawData): List<CoinPriceInfo> {
        val result = ArrayList<CoinPriceInfo>()
        val jsonObject = coinPriceInfoRawData.coinPriceInfoJsonProject ?: return result
        val coinKeySet = jsonObject.keySet()
        for (coinKey in coinKeySet) {
            val currencyJson = jsonObject.getAsJsonObject(coinKey)
            val currencyKeySet = currencyJson.keySet()
            for (currencyKey in currencyKeySet) {
                val priceInfo = Gson().fromJson(currencyJson.getAsJsonObject(currencyKey), CoinPriceInfo::class.java)
                result.add(priceInfo)
            }
        }
        return result
    }

    override fun onCleared() {
        super.onCleared()
    }
}