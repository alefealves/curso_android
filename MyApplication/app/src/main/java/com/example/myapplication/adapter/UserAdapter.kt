package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.list_user_item.view.*


class UserAdapter(private val users: List<User>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_user_item, parent, false)

        val viewHolder = UserViewHolder(view)

        return viewHolder
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = users[position]
        holder.bindData(user)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    class UserViewHolder( val view: View) : RecyclerView.ViewHolder(view) {

        fun bindData(user: User) {
            view.user_name.text = user.userName
            view.user_age.text = user.userPass
        }
    }
}