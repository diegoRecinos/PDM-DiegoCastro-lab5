package com.pdm0126.lab5.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.TaskEntity

@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}
