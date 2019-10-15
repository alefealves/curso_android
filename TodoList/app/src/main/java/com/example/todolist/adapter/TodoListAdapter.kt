package com.example.todolist.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.DetailActivity
import com.example.todolist.R
import com.example.todolist.models.TodoList
import kotlinx.android.synthetic.main.list_item.view.*

class TodoListAdapter(private val todolists: MutableList<TodoList>) : RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    fun addTodo(todo: TodoList) {
        this.todolists.add(todo)
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

            view.setOnClickListener {
                val intent = Intent(view.context,DetailActivity::class.java)
                intent.putExtra("todo",todoList)
                view.context.startActivity(intent)
            }

            view.descricao.text = todoList.descricao
            view.status.isChecked = todoList.status

            view.status.setOnClickListener {
                todoList.status = !it.status.isChecked
            }
        }
    }
}