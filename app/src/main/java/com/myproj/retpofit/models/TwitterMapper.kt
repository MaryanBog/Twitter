package com.myproj.retpofit.models

class TwitterMapper {

    fun mapApiToUI(api: TwitterApi): Twitter {
       return when {
            api.quote != null -> TwitterQuote(
                id = api.id,
                userName = api.userName,
                displayName = api.displayName,
                quote = api.quote,
                avatar = api.avatar,
                text = api.text
            )
            api.image != null -> TwitterImage(
                id = api.id,
                userName = api.userName,
                displayName = api.displayName,
                image = api.image,
                avatar = api.avatar,
                text = api.text
            )
            else -> TwitterSimple(
                id = api.id,
                userName = api.userName,
                displayName = api.displayName,
                avatar = api.avatar,
                text = api.text
            )
        }
    }
}