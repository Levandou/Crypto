package com.example.kotlimn.POJO

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CoinInfoLIstOfData(    @SerializedName("Data")
                                  @Expose
                                   val data:List<Datum>? = null)