package com.example.myapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapplication.vo.dao.LoginDao

@Database(
    entities = [LoginDao::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class MyAppDatabase : RoomDatabase() {
    companion object {
        // For Singleton instantion
        @Volatile
        private var instance: MyAppDatabase? = null

        fun getInstance(context: Context): MyAppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): MyAppDatabase {
            return Room.databaseBuilder(context, MyAppDatabase::class.java, "itstime-db")
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}