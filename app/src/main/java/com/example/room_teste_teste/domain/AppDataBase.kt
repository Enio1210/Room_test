package com.comunidadedevspace.taskbeats.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


 @Database(entities = [Task::class], version = 1)
 abstract class AppDataBase: RoomDatabase() {
     abstract fun taskDao(): TaskDao

     //criar referencência estática
     //devolver sempre a mesma instancia do AppDataBase
     //é necessário para fazer a leitura automatica considerando as mudanças do
     //banco de dados
     companion object {
         @Volatile
         private var db: AppDataBase? = null

         fun instancia(context: Context): AppDataBase {
             return db ?: Room.databaseBuilder(
                 context,
                 AppDataBase::class.java,
                 "room-teste.db"
             ).build().also {
                 db = it
             }
         }
     }
}

