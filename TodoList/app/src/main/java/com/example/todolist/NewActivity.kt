package com.example.todolist

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new.*

class NewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        save.setOnClickListener {
            var description = task_description.text.toString()

            val intent = Intent()
            intent.putExtra("todo",description)
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}
