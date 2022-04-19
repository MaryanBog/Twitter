package com.myproj.retpofit.models

sealed class Twitter
data class TwitterSimple(
    val id: Int,
    val userName: String,
    val displayName: String,
    val avatar: String,
    val text: String,
    val viewType: Int = 0
) : Twitter()

data class TwitterQuote(
    val id: Int,
    val userName: String,
    val displayName: String,
    val quote: Quote,
    val avatar: String,
    val text: String,
    val viewType: Int = 1
) : Twitter()

data class TwitterImage(
    val id: Int,
    val userName: String,
    val displayName: String,
    val image: String,
    val avatar: String,
    val text: String,
    val viewType: Int = 2
) : Twitter()
