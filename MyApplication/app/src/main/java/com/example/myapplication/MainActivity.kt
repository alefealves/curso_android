package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
