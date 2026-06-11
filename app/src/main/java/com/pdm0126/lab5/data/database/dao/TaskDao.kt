package com.pdm0126.lab5.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pdm0126.lab5.data.database.entities.TaskEntity
import com.pdm0126.lab5.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao{
    @Query ("SELECT * FROM tasks")
    fun getAllTasks(): Flow<List<TaskEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask(task: TaskEntity)

    @Query("DELETE FROM tasks")
    suspend fun deleteAllTasks()

}

