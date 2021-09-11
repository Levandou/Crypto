package com.example.kotlimn



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.kotlimn.POJO.CoinPriceInfo
import com.example.kotlimn.adapters.CoinInfoAdapter
import kotlinx.android.synthetic.main.activity_coin_price_list.*

class CoinPriceListActivity : AppCompatActivity() {
    private lateinit var viewModel: CoinViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_price_list)
        val adapter=CoinInfoAdapter(this)
        adapter.onCoinClickListener= object :CoinInfoAdapter.OnCoinClickListener  {
            override fun onCoinClick(coinPriceInfo: CoinPriceInfo) {
            val intent= CoinDetailActivity.newIntent(this@CoinPriceListActivity,coinPriceInfo.fromsymbol)//более удобный способ передачи параметров
                startActivity(intent)
            }

        }
        rvCoinPriceList.adapter=adapter
        viewModel = ViewModelProviders.of(this).get(CoinViewModel::class.java)
            viewModel.priceList.observe(this, Observer {
            adapter.coinInfoList=it
            })


    }


}






