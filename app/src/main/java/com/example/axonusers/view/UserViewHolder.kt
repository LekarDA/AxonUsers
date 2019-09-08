package com.example.axonusers.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.axonusers.data.Results
import com.example.axonusers.data.User
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_of_user.view.*

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private var view: View = itemView

    fun initView(user: Results?) {
            Picasso.with(itemView.context).load(user?.picture?.large ).into(view.profileImage)
            val nameConcat = "${user?.name?.last} ${user?.name?.first}"
            view.tvName.text = nameConcat
    }
}