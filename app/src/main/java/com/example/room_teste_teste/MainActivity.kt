package com.example.room_teste_teste

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import com.comunidadedevspace.taskbeats.data.local.Task
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val taskListAdapter = TaskListAdapter(
            openTaskDetailView = {

            },
        )

        // cria instancia do room
        val db = AppDataBase.instancia(this)
        val dao = db.taskDao()

        // le os dados de maneira reativa
        // cada atualizacao no banco, é executado novamente o collect
        // atualiza o adapter do recyclerview
        lifecycleScope.launch {
            dao.getAll().collect {tasks ->
                taskListAdapter.add(tasks)
            }
        }


        val rvTask: RecyclerView = findViewById(R.id.recyclerView)
        rvTask.adapter = taskListAdapter


        val fab = findViewById<Button>(R.id.btnAdd)
        fab.setOnClickListener {
            //abre nova activity
            Intent(this, TaskDetailActivity::class.java).let {
                startActivity(it)
            }
        }
    }
}