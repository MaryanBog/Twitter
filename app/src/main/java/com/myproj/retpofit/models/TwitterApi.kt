package com.myproj.retpofit.models

data class TwitterApi(
    val id:Int,
    val userName: String,
    val displayName: String,
    val quote: Quote?,
    val image: String?,
    val avatar: String,
    val text: String
)