package com.example.kotlimn.api

import com.example.kotlimn.POJO.CoinInfoLIstOfData
import com.example.kotlimn.POJO.CoinPriceInfoRawData
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ApiSevice {



    @GET ("top/totalvolfull")
    fun getTopCoinsInfo
            (
            @Query(QUERY_PARAM_API_KEY) api_key :String="123321",
            @Query(QUERY_PARAM_LIMIT) limit :Int=10,
            @Query(QUERY_PARAM_TO_SYMBOL) tSym :String= CURRENCY
            ):Single<CoinInfoLIstOfData>



    @GET("pricemultifull")
    fun getFullPriceList(
            @Query(QUERY_PARAM_API_KEY) api_key :String="123321",

            @Query(QUERY_PARAM_TO_SYMBOLS) tSyms :String= CURRENCY,
            @Query(QUERY_PARAM_FROM_SYMBOLS) fSyms :String


    ):Single<CoinPriceInfoRawData>

    companion object{
        private const val QUERY_PARAM_API_KEY="api_key"
        private const val QUERY_PARAM_LIMIT="limit"
        private const val QUERY_PARAM_TO_SYMBOL="tsym"

        private const val QUERY_PARAM_TO_SYMBOLS="tsyms"
        private const val QUERY_PARAM_FROM_SYMBOLS="fsyms"

        private const val CURRENCY="USD"

    }

}