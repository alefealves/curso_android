package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.list_item.view.*

class TodoListAdapter(private val todolists: List<TodoList>) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    val todos = mutableListOf<TodoList>()

    fun setData(todos: List<TodoList>){
        this.todos.addAll(todos)
    }

    fun addTodo(todo: TodoList) {
        this.todos.add(todo)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item, parent, false)

        val viewHolder = TodoViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {

        val todoList = todolists[position]
        holder.bindData(todoList)
    }

    override fun getItemCount(): Int {
        return todolists.size
    }

    class TodoViewHolder( val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(todoList: TodoList) {
            view.id_task.text = todoList.id.toString()
            view.descricao.text = todoList.descricao
            view.status.text = todoList.status.toString()
        }
    }
}