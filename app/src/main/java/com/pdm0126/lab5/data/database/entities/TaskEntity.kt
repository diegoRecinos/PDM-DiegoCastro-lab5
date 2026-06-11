package com.pdm0126.lab5.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Long = System.currentTimeMillis(),
    val isCompleted: Boolean = false
)
