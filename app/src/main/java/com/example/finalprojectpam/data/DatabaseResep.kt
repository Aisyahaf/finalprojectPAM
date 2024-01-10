package com.example.finalprojectpam.data

import android.content.Context
import android.provider.CalendarContract.Instances
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Resep::class], version = 1, exportSchema = false)
abstract class DatabaseResep : RoomDatabase(){
    abstract fun resepDao() : ResepDao

    companion object{
        @Volatile
        private var Instance: DatabaseResep? = null

        fun getDatabase(context: Context): DatabaseResep{
            return (Instance?: synchronized( this){
                Room.databaseBuilder(context,DatabaseResep::class.java, "resep_database")
                    .build().also { Instance = it }
            })
        }
    }
}