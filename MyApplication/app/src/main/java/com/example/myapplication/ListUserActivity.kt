package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.adapter.UserAdapter
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_list_user.*

class ListUserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_user)

        val user1 = User("User1", "pass")
        val user2 = User("User2", "pass")
        val user3 = User("User3", "pass")

        val users = mutableListOf(user1, user2, user3)


        val viewManager = LinearLayoutManager(this)
        val userAdapter = UserAdapter(users)

        user_list.layoutManager = viewManager
        user_list.adapter = userAdapter

    }
}
