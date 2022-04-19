package com.myproj.retpofit

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView

abstract class MyViewHolder(itemView: View, val delegate: TwitterDelegate?) :
    RecyclerView.ViewHolder(itemView) {
    val txtUserName: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_user_name)
    val txtDisplayName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_twitt_name)
    val txtText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_text)
    val imgAvatar: ImageView = itemView.findViewById(R.id.img_twitt_avatar)
}