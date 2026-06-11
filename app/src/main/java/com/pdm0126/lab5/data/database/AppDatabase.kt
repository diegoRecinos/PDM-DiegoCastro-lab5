package com.pdm0126.lab5.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.Post

@Database(entities = [Post::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): TaskDao
}

class InitDatabase : Application() {
    companion object{
        lateinit var database: AppDatabase
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        ).fallbackToDestructiveMigration(false).build()
    }
}