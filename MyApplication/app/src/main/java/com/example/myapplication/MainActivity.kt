package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user1 = User(userName = "User1", userPass = "pass")
        val user2 = User(userName = "User2", userPass = "pass")
        val user3 = User(userName = "User3", userPass = "pass")

        val numbers = mutableListOf(user1,user2)

        numbers.add(0,user3)

        numbers.forEach {
            Log.d("username",it.userName)
        }

        val bundle = Bundle()

        val intent = Intent(this, SecondActivity::class.java)

        login.setOnClickListener {

            //bundle.putString("user_name",user_name.text.toString())
            //bundle.putString("user_pass",user_pass.text.toString())
            val user = User(user_name.text.toString(), user_pass.text.toString())

            bundle.putParcelable("user", user)

            intent.putExtras(bundle)

            startActivity(intent)

        }
    }
}
