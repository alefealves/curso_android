package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.adapter.TodoListAdapter
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {
    val IDENTIFY_REQUEST  = 123

    //lateinit var TodoListAdapter: TodoListAdapter
    val listAdapter = TodoListAdapter(mutableListOf<TodoList>())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listAdapter.setData(initTodos())

        /*val task1 = TodoList(0,"Ir ao Cinema",false)
        val task2 = TodoList(1,"Ir a Praia",true)
        val task3 = TodoList(2,"Ir ao Shopping",false)

        val tasks = mutableListOf(task1, task2, task3)
        tasks.add(task1)*/

        new_task.setOnClickListener {
            val intent = Intent(applicationContext, NewActivity::class.java)
            startActivityForResult(intent, IDENTIFY_REQUEST)
        }

        val viewManager = LinearLayoutManager(this)
        val divider = DividerItemDecoration(this, viewManager.orientation)

        task_list.layoutManager = viewManager
        task_list.addItemDecoration(divider)
        task_list.adapter = listAdapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == IDENTIFY_REQUEST) {

            if (resultCode == Activity.RESULT_OK) {
                data?.let {
                    val description = it.getStringExtra("todo")
                    val todo = TodoList(2,description,false)
                    listAdapter.addTodo(todo)
                }
            }
        }
    }

    private fun initTodos(): MutableList<TodoList>{
        val task1 = TodoList(0,"Estudar Android",false)
        val task2 = TodoList(1,"Estudar Recyclerview",true)
        val task3 = TodoList(2,"Estudar Kotlin",false)

        val tasks = mutableListOf(task1, task2, task3)
        return tasks
    }
}
