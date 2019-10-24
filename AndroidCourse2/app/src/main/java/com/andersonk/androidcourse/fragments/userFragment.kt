package com.andersonk.androidcourse.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.andersonk.androidcourse.R
import com.andersonk.androidcourse.adapters.UserAdapter
import com.andersonk.androidcourse.models.UserList
import com.andersonk.androidcourse.services.Api
import kotlinx.android.synthetic.main.user_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class userFragment : Fragment () {

    lateinit var userAdapter: UserAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        var view = inflater.inflate(R.layout.user_fragment,container,false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userAdapter = UserAdapter()

        val layoutManager = LinearLayoutManager(context)

        recycle_users.layoutManager = layoutManager
        recycle_users.adapter = userAdapter

        getData()
    }

    private fun getData(){

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.stackexchange.com/2.2/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        val service = retrofit.create<Api>(Api::class.java)

        val call = service.getUsers(
            mapOf(
                "order" to "desc",
                "sort" to "name",
                "site" to "stackoverflow"
            )
        )

        call.enqueue(object : Callback<UserList> {
            override fun onFailure(call: Call<UserList>, t: Throwable) {
                Log.d("NETWORK", t.toString())
            }

            override fun onResponse(call: Call<UserList>, response: Response<UserList>) {
                when(response.code()){
                    200 -> {
                        val body = response.body()
                        body?.let{
                            userAdapter.setUsers(it.users)
                        }
                    }
                    204 -> Log.d("NETWORK","Not content")
                }
            }

        })
    }

}