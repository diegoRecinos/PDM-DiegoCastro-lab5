package com.pdm0126.lab5.data.repository

import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.TaskEntity
import com.pdm0126.lab5.data.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date

class TaskRepository(private val taskDao: TaskDao) {
    
    // Convertimos la lista de entidades a lista de modelos de dominio
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks().map { entities ->
        entities.map { entity ->
            Task(
                id = entity.id,
                title = entity.title,
                description = entity.description,
                endDate = Date(entity.endDate),
                isCompleted = entity.isCompleted
            )
        }
    }

    // Convertimos el modelo de dominio a entidad para guardar
    suspend fun insert(task: Task) {
        val entity = TaskEntity(
            id = task.id,
            title = task.title,
            description = task.description,
            endDate = task.endDate.time,
            isCompleted = task.isCompleted
        )
        taskDao.insertTask(entity)
    }
}
