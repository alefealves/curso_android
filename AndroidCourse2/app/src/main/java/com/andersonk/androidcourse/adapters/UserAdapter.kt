package com.andersonk.androidcourse.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Placeholder
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import coil.transform.CircleCropTransformation
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.models.User
import com.andersonk.androidcourse.models.UserList
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>(){

    val users = mutableListOf<User>()

    fun setUsers(users : MutableList<User>){
        this.users.addAll(users)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.user_item, parent,false)
        return UserHolder(view)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val users = users[position]
        holder.setUser(users)
    }

    class UserHolder(private val view : View) : RecyclerView.ViewHolder(view){
        fun setUser(user : User){

            view.profile_image.load(user.profile_image) {
                crossfade(true)
                placeholder(R.mipmap.ic_launcher)
                transformations(CircleCropTransformation())
            }

            view.display_name.text = user.display_name
            view.creation_date.text = user.creation_date.toString()

        }
    }
}