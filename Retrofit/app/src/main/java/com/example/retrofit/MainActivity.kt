package com.example.retrofit

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.retrofit.services.Api

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            retrofitTest()
        }
    }

    private fun retrofitTest(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getBadges(
            mapOf(
                "order" to "desc",
                "sort" to "rank",
                "site" to "stackoverflow"
            )
        )

        call.enqueue(object : Callback<Any> {

            override  fun onResponse(call: Call<Any>, response: Response<Any>){
                when (response.code()){
                    200 -> {
                        
                        Log.d("NETWORK", response.body().toString())
                    }
                    204 -> Log.d("NETWORK", "Not content")
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable){
                Log.d("NETWORK", t.toString())
            }

        })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
