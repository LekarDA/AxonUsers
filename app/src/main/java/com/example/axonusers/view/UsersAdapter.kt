package com.example.axonusers.view

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.axonusers.R
import com.example.axonusers.data.Results
import com.example.axonusers.data.User
import com.example.axonusers.listen
import java.util.ArrayList

class UsersAdapter: RecyclerView.Adapter<UserViewHolder>() {

    var users: ArrayList<Results>? = ArrayList()
    private lateinit var listener: OnUserClickListener


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_of_user,parent,false)
        return UserViewHolder(view).listen { position, type ->
            listener.onUserClick(position)
        }
    }

    override fun getItemCount(): Int {
        return users?.size ?: 0
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.initView(user = users?.get(position))
    }

    fun setData(listOfUsers: List<Results>) {
        users?.clear()
        users?.addAll(listOfUsers)
        Log.e("ADAPTER", "set data size " + users?.size.toString())
        notifyDataSetChanged()
    }

    fun setItemClickListener(listener : OnUserClickListener){
        this.listener = listener
    }
}