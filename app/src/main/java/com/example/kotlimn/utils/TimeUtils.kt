package com.example.kotlimn.utils

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

fun convertTimestampToTime(timeStamp:Int?):String{
    if(timeStamp==null) return ""
    val stamp=Timestamp((timeStamp*1000).toLong())
    val date=Date(stamp.time)
    val pattern="HH:mm:ss"
    val sdf=SimpleDateFormat(pattern,Locale.getDefault())
    sdf.timeZone= TimeZone.getDefault()
    return sdf.format(date)
}