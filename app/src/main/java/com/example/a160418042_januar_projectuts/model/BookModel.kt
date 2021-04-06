package com.example.a160418042_januar_projectuts.model

import com.google.gson.annotations.SerializedName

data class Book(
    val id:String?,
    val judul:String?,
    val kategori:String?,
    val author:String?,
    val about:String?,
    @SerializedName("image_url")
    val image_url:String?
)