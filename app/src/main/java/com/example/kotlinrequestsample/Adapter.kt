package com.example.kotlinrequestsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrequestsample.model.Data
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.view.*

class Adapter (private val dataList: MutableList<Data>) : RecyclerView.Adapter<Holder>() {

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        context = parent.context
        return Holder(LayoutInflater.from(context).inflate(R.layout.activity_main,parent,false))

    }

    override fun getItemCount(): Int = dataList.size



    override fun onBindViewHolder(holder: Holder, position: Int) {
        val data = dataList[position]

        val userFullNameTextView = holder.itemView.user_full_name
        val userAvatarImgView = holder.itemView.user_avatar

        val fullName = "${data.firstName} ${data.lastName}"
        userFullNameTextView.text = fullName

        Picasso.get()
            .load(data.avatar)
            .into(userAvatarImgView)

        holder.itemView.setOnClickListener{
            Toast.makeText(context,fullName,Toast.LENGTH_SHORT).show()
        }
    }
}