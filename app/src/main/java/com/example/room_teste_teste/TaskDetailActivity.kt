package com.example.room_teste_teste

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import com.comunidadedevspace.taskbeats.data.local.Task
import kotlinx.coroutines.launch

class TaskDetailActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.task_detail_activity)

        val db = AppDataBase.instancia(this)
        val dao = db.taskDao()

        val titleEditText = findViewById<EditText>(R.id.title_rv)
        val descriptionEditText = findViewById<EditText>(R.id.descripition_rv)

        val btnDone = findViewById<Button>(R.id.btn_done)
        btnDone.setOnClickListener {
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            // salva o dado no banco de dados
            lifecycleScope.launch {
                dao.save(Task(
                    title = title,
                    description = description
                ))
            }
            finish()
        }
    }
}