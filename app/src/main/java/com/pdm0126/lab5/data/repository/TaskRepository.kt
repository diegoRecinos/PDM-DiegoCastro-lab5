package com.pdm0126.lab5.data.repository

import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.toEntity
import com.pdm0126.lab5.data.database.entities.toModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import com.pdm0126.lab5.data.model.Task

class TaskRepository(private val taskDao: TaskDao) {

    // Convertimos la lista de entidades a lista de modelos usando el mapper
    val allTasks: Flow<List<Task>> = taskDao.getAllTasks().map{
        entities -> entities.map { it.toModel() }
    }

    // Convertimos el modelo a entidad usando el mapper para guardar
    suspend fun insertTask(task: Task) {
        taskDao.insertTask(task.toEntity())
    }
}