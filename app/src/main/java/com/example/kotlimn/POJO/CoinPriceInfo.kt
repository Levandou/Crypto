package com.example.kotlimn.POJO

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.kotlimn.api.ApiFactory.BASE_IMAGE_URL
import com.example.kotlimn.utils.convertTimestampToTime
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity(tableName = "full_price_list")
data class CoinPriceInfo(
    @SerializedName("TYPE")
        @Expose
    public val type: String? = null,

    @SerializedName("MARKET")
    @Expose
    public val market: String? = null,

    @PrimaryKey
    @SerializedName("FROMSYMBOL")
    @Expose
    public val fromsymbol: String = "",

    @SerializedName("TOSYMBOL")
    @Expose
    public val tosymbol: String? = null,

    @SerializedName("FLAGS")
    @Expose
    public val flags: String? = null,

    @SerializedName("PRICE")
    @Expose
    public val price: Double? = null,

    @SerializedName("LASTUPDATE")
    @Expose
    public val lastupdate: Int? = null,

    @SerializedName("MEDIAN")
    @Expose
    public val median: Double? = null,

    @SerializedName("LASTVOLUME")
    @Expose
    public val lastvolume: Double? = null,

    @SerializedName("LASTVOLUMETO")
    @Expose
    public val lastvolumeto: Double? = null,

    @SerializedName("LASTTRADEID")
    @Expose
    public val lasttradeid: String? = null,

    @SerializedName("VOLUMEDAY")
    @Expose
    public val volumeday: Double? = null,

    @SerializedName("VOLUMEDAYTO")
    @Expose
    public val volumedayto: Double? = null,

    @SerializedName("VOLUME24HOUR")
    @Expose
    public val volume24hour: Double? = null,

    @SerializedName("VOLUME24HOURTO")
    @Expose
    public val volume24hourto: Double? = null,

    @SerializedName("OPENDAY")
    @Expose
    public val openday: Double? = null,

    @SerializedName("HIGHDAY")
    @Expose
    public val highday: Double? = null,

    @SerializedName("LOWDAY")
    @Expose
    public val lowday: Double? = null,

    @SerializedName("OPEN24HOUR")
    @Expose
    public val open24hour: Double? = null,

    @SerializedName("HIGH24HOUR")
    @Expose
    public val high24hour: Double? = null,

    @SerializedName("LOW24HOUR")
    @Expose
    public val low24hour: Double? = null,

    @SerializedName("LASTMARKET")
    @Expose
    public val lastmarket: String? = null,

    @SerializedName("VOLUMEHOUR")
    @Expose
    public val volumehour: Double? = null,

    @SerializedName("VOLUMEHOURTO")
    @Expose
    public val volumehourto: Double? = null,

    @SerializedName("OPENHOUR")
    @Expose
    public val openhour: Double? = null,

    @SerializedName("HIGHHOUR")
    @Expose
    public val highhour: Double? = null,

    @SerializedName("LOWHOUR")
    @Expose
    public val lowhour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOUR")
    @Expose
    public val toptiervolume24hour: Double? = null,

    @SerializedName("TOPTIERVOLUME24HOURTO")
    @Expose
    public val toptiervolume24hourto: Double? = null,

    @SerializedName("CHANGE24HOUR")
    @Expose
    public val change24hour: Double? = null,

    @SerializedName("CHANGEPCT24HOUR")
    @Expose
    public val changepct24hour: Double? = null,

    @SerializedName("CHANGEDAY")
    @Expose
    public val changeday: Double? = null,

    @SerializedName("CHANGEPCTDAY")
    @Expose
    public val changepctday: Double? = null,

    @SerializedName("CHANGEHOUR")
    @Expose
    public val changehour: Double? = null,

    @SerializedName("CHANGEPCTHOUR")
    @Expose
    public val changepcthour: Double? = null,

    @SerializedName("CONVERSIONTYPE")
    @Expose
    public val conversiontype: String? = null,

    @SerializedName("CONVERSIONSYMBOL")
    @Expose
    public val conversionsymbol: String? = null,

    @SerializedName("SUPPLY")
    @Expose
    public val supply: Int? = null,

    @SerializedName("MKTCAP")
    @Expose
    public val mktcap: Double? = null,

    @SerializedName("MKTCAPPENALTY")
    @Expose
    public val mktcappenalty: Int? = null,

    @SerializedName("TOTALVOLUME24H")
    @Expose
    public val totalvolume24h: Double? = null,

    @SerializedName("TOTALVOLUME24HTO")
    @Expose
    public val totalvolume24hto: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24H")
    @Expose
    public val totaltoptiervolume24h: Double? = null,

    @SerializedName("TOTALTOPTIERVOLUME24HTO")
    @Expose
    public val totaltoptiervolume24hto: Double? = null,

    @SerializedName("IMAGEURL")
    @Expose
    public val imageurl: String? = null,
    )
{
    fun getFormattedTime():String{
        return convertTimestampToTime(lastupdate)
    }

    fun getFullImageUrl():String{
return BASE_IMAGE_URL+imageurl
    }
}