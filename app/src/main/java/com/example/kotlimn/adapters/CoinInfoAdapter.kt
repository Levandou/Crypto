package com.example.kotlimn.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlimn.POJO.CoinInfo
import com.example.kotlimn.POJO.CoinPriceInfo
import com.example.kotlimn.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_coin_info.view.*

class CoinInfoAdapter(private val context: Context) : RecyclerView.Adapter<CoinInfoAdapter.CoinInfoViewHolder>() {

    var coinInfoList:List<CoinPriceInfo> = arrayListOf<CoinPriceInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCoinClickListener:OnCoinClickListener?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinInfoViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_coin_info, parent, false)
        return CoinInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinInfoViewHolder, position: Int) {
        val coin = coinInfoList[position]
        with(holder) {
            with(coin) {
                val symbolsTemplate=context.resources.getString(R.string.symbols_template)
                val lastUpdateTemplate=context.resources.getString(R.string.last_update_template)
                tvSymbols.text = String.format(symbolsTemplate ,fromsymbol , tosymbol)
                tvPrice.text = price.toString()
                tvLastUpdate.text =String.format(lastUpdateTemplate,getFormattedTime())
                Picasso.get().load(getFullImageUrl()).into(holder.ivLogoCoin)
                itemView.setOnClickListener{
                    onCoinClickListener?.onCoinClick(this)
                }
            }
        }
    }

    override fun getItemCount() = coinInfoList.size

    inner class CoinInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivLogoCoin = itemView.ivLogoCoin
        val tvLastUpdate = itemView.tvLastUpdate
        val tvPrice = itemView.tvPrice
        val tvSymbols = itemView.tvSymbols
    }

    interface OnCoinClickListener{
        fun onCoinClick(coinPriceInfo: CoinPriceInfo)
    }


}