package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        intent.extras?.let {
            val todo= intent.getParcelableExtra<TodoList>("todo")

            desc_detail.text = todo.descricao
        }
    }
}
