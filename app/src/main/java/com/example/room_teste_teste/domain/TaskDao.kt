package com.comunidadedevspace.taskbeats.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(task: Task)

    @Query("Select * from task")
    fun getAll(): Flow<List<Task>>

    //deleta todas
    @Query("DELETE from task")
    suspend fun deleteAll()

    //deleta pelo id
    @Query("DELETE from task WHERE id = :id ")
    suspend fun deleteById(id: Int)


}