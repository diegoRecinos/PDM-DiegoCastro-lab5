package com.pdm0126.lab5.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}


class InitDatabase: Application() {
    companion object {
        lateinit var database: AppDatabase

    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration(false).build()

    }

}