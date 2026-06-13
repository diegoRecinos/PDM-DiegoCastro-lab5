package com.pdm0126.lab5.data.database

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm0126.lab5.data.database.dao.TaskDao
import com.pdm0126.lab5.data.database.entities.TaskEntity

// Definimos la base de datos sea una room database
@Database(entities = [TaskEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
}


class InitDatabase: Application() {
    //acceder a la base de datos desde cualquier lugar de la app  guarda la instancia de la base de datos
    //se instancia un singleton
    companion object {
        lateinit var database: AppDatabase

    }

    //antes de iniciar la app, creamos la base de datos
    override fun onCreate() {
        super.onCreate()

        // inicializar la instancia y se le pasa un contexto
        //para que se identifique la base de datos
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "app_database"
            //evitamos que se destruya la base de datos al cambiar de versión
        ).fallbackToDestructiveMigration(false).build()

    }

}