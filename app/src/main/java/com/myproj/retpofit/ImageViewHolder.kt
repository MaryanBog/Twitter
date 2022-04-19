package com.myproj.retpofit

import android.view.View
import android.widget.ImageView
import com.myproj.retpofit.models.TwitterImage
import com.squareup.picasso.Picasso

class ImageViewHolder(itemView: View, delegate: TwitterDelegate?): MyViewHolder(itemView, delegate) {
    private val imgContent: ImageView = itemView.findViewById(R.id.img_twitt_content)
    fun bind(model: TwitterImage) {
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

        imgContent.setOnClickListener {
            delegate?.openImage(url = model.image)
        }

        Picasso.get().load(model.avatar).into(imgAvatar)
        Picasso.get().load(model.image).into(imgContent)
    }
}