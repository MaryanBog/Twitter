package com.myproj.retpofit

import android.view.View
import com.myproj.retpofit.models.Twitter
import com.myproj.retpofit.models.TwitterSimple
import com.squareup.picasso.Picasso

class TextViewHolder(itemView: View, delegate: TwitterDelegate?): MyViewHolder(itemView, delegate) {
    fun bind(model: TwitterSimple) {
        txtUserName.apply {
            text = model.userName
            setOnClickListener {
                delegate?.openProfile(username = model.userName)
            }
        }

        txtDisplayName.apply {
            text = model.displayName
            setOnClickListener {
                delegate?.openProfile(username = model.userName)
            }
        }

        txtText.text = model.text

        imgAvatar.setOnClickListener {
            delegate?.openImage(url = model.avatar)
        }

        Picasso.get().load(model.avatar).into(imgAvatar)
    }
}