package com.example.kotlimn.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.example.kotlimn.POJO.CoinPriceInfo
import retrofit2.http.Query


@Dao
interface CoinPriceInfoDao {
    @androidx.room.Query("SELECT * FROM full_price_list ORDER BY lastUpdate DESC ")
    fun getPriceList():LiveData<List<CoinPriceInfo>>

    @androidx.room.Query("SELECT * FROM full_price_list WHERE fromsymbol == :fSym LIMIT 1")
    fun getPriceInfoAboutCoin(fSym:String):LiveData<CoinPriceInfo>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPriceList(priceList:List<CoinPriceInfo> )
}