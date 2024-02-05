package com.example.room_teste_teste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.data.local.Task
import java.io.Serializable

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val  rvTask: RecyclerView= findViewById(R.id.recyclerView)
        rvTask.adapter


        val fab= findViewById<Button>(R.id.btnAdd)
        fab.setOnClickListener {

        }
    }
}
