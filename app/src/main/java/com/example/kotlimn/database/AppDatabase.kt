package com.example.kotlimn.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlimn.POJO.CoinPriceInfo
import java.security.AccessControlContext


@Database(entities = [CoinPriceInfo::class],version = 1,exportSchema = false)
abstract class AppDatabase:RoomDatabase() {
    companion object{
        private const val DB_NAME="main.db"
        private var db:AppDatabase? =null
        private val LOCK=Any()

        fun getInstance(context:Context):AppDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance: AppDatabase =
                    Room.databaseBuilder(context, AppDatabase::class.java, DB_NAME).build()
                db = instance
                return instance
            }
        }
    }
abstract fun coinPriceInfoDao():CoinPriceInfoDao
}