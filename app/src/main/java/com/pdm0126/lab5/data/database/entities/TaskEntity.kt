package com.pdm0126.lab5.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pdm0126.lab5.data.model.Task
import java.util.Date

@Entity(tableName = "tasks")
data class TaskEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val endDate: Long = Date().time,
    val isCompleted: Boolean
)

// Mapear de Entidad a Modelo
fun TaskEntity.toModel(): Task {
    return Task(
        id = id,
        title = title,
        description = description,
        endDate = Date(endDate),
        isCompleted = isCompleted
    )
}

// Mapear de Modelo a Entidad
fun Task.toEntity(): TaskEntity {
    return TaskEntity(
        id = id,
        title = title,
        description = description,
        endDate = endDate.time,
        isCompleted = isCompleted
    )
}