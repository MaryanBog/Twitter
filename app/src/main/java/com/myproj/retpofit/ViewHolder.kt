package com.myproj.retpofit

import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.myproj.retpofit.models.TwitterImage
import com.myproj.retpofit.models.TwitterQuote
import com.myproj.retpofit.models.TwitterSimple
import com.squareup.picasso.Picasso

class TextViewHolder(itemView: View, val delegate: TwitterDelegate?) : RecyclerView.ViewHolder(itemView) {
    private val txtUserName: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_user_name)
    private val txtDisplayName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_twitt_name)
    private val txtText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_text)
    private val imgAvatar: ImageView = itemView.findViewById(R.id.img_twitt_avatar)
    fun bind(model: TwitterSimple) {
        txtUserName.text = model.userName
        txtDisplayName.text = model.displayName
        txtText.text = model.text

        txtUserName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

        txtDisplayName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

        imgAvatar.setOnClickListener {
            delegate?.openImage(url = model.avatar)
        }

        Picasso.get().load(model.avatar).into(imgAvatar)
    }
}

class QuoteViewHolder(itemView: View, val delegate: TwitterDelegate?) : RecyclerView.ViewHolder(itemView) {
    private val txtUserName: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_user_name)
    private val txtDisplayName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_twitt_name)
    private val txtText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_text)
    private val txtQuoteText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_quote_text)
    private val txtQuoteUserName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_quote_user_name)
    private val imgAvatar: ImageView = itemView.findViewById(R.id.img_twitt_avatar)
    fun bind(model: TwitterQuote) {
        txtUserName.text = model.userName
        txtDisplayName.text = model.displayName
        txtText.text = model.text
        txtQuoteText.text = model.quote.text
        txtQuoteUserName.text = model.quote.userName

        txtUserName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

        txtDisplayName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

        imgAvatar.setOnClickListener {
            delegate?.openImage(url = model.avatar)
        }

        txtQuoteUserName.setOnClickListener {
            delegate?.openProfile(username = model.quote.userName)
        }

        Picasso.get().load(model.avatar).into(imgAvatar)
    }
}

class ImageViewHolder(itemView: View, val delegate: TwitterDelegate?) : RecyclerView.ViewHolder(itemView) {
    private val txtUserName: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_user_name)
    private val txtDisplayName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_twitt_name)
    private val txtText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_text)
    private val imgContent: ImageView = itemView.findViewById(R.id.img_twitt_content)
    private val imgAvatar: ImageView = itemView.findViewById(R.id.img_twitt_avatar)
    fun bind(model: TwitterImage) {
        txtUserName.text = model.userName
        txtDisplayName.text = model.displayName
        txtText.text = model.text

        txtUserName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

        txtDisplayName.setOnClickListener {
            delegate?.openProfile(username = model.userName)
        }

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