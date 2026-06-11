package com.pdm0126.lab5.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

data class Task (
    val id: Int,
    val title: String,
    val description: String,
    val endDate: Date = Date(),
    val isCompleted: Boolean = false
)
