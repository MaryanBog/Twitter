package com.myproj.retpofit

import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import com.myproj.retpofit.models.TwitterQuote
import com.squareup.picasso.Picasso

class QuoteViewHolder(itemView: View, delegate: TwitterDelegate?) :
    MyViewHolder(itemView, delegate) {
    private val txtQuoteText: AppCompatTextView = itemView.findViewById(R.id.txt_twitt_quote_text)
    private val txtQuoteUserName: AppCompatTextView =
        itemView.findViewById(R.id.txt_twitt_quote_user_name)

    fun bind(model: TwitterQuote) {
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
        txtQuoteText.text = model.quote.text
        txtQuoteUserName.apply {
            text = model.quote.userName
            setOnClickListener {
                delegate?.openProfile(username = model.quote.userName)
            }
        }

        imgAvatar.setOnClickListener {
            delegate?.openImage(url = model.avatar)
        }

        Picasso.get().load(model.avatar).into(imgAvatar)
    }
}