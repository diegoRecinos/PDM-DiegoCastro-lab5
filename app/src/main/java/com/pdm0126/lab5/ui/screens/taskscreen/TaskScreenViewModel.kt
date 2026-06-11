package com.pdm0126.lab5.ui.screens.taskscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.lab5.data.database.InitDatabase
import com.pdm0126.lab5.data.model.Task
import com.pdm0126.lab5.data.repository.TaskRepository // Ojo con la ruta, tenías "repositories"
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class GeneralViewModel : ViewModel() {

    // 1. Inicializamos el repositorio con el DAO
    private val repository = TaskRepository(InitDatabase.database.taskDao())

    // 2. Conectamos el Flow del repositorio directamente a un StateFlow para la UI
    val tasks: StateFlow<List<Task>> = repository.allTasks
        .stateIn(
            scope = viewModelScope,
            // Mantiene el flujo activo 5s tras salir de la pantalla
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList() // Estado inicial mientras carga la base de datos
        )


    fun addTask(task: Task) {
        viewModelScope.launch {
            repository.insertTask(task)
        }
    }
}