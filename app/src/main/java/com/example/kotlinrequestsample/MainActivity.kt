package com.example.kotlinrequestsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.example.kotlinrequestsample.model.Data
import com.example.kotlinrequestsample.model.DataItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val dataList: MutableList<Data> = mutableListOf()
    private lateinit var Adapter:Adapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Adapter = Adapter(dataList)

        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        my_recycler_view.adapter = Adapter




        AndroidNetworking.initialize(this)

        AndroidNetworking.get("https://reqres.in/api/users?page=2")
            .build()
            .getAsObject(Data::class.java, object : ParsedRequestListener<Data> {
                override fun onResponse(response: Data?) {

                }

                override fun onError(anError: ANError?) {

                }

            }
        )
    }
}