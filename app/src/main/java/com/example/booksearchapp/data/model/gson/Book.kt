package com.example.booksearchapp.data.model.gson


import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("authors")
    val authors: List<String>,
    @SerializedName("contents")
    val contents: String,
    @SerializedName("datetime")
    val datetime: String,
    @SerializedName("isbn")
    val isbn: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("sale_price")
    val salePrice: Int,
    @SerializedName("status")
    val status: String,
    @SerializedName("thumbnail")
    val thumbnail: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("translators")
    val translators: List<String>,
    @SerializedName("url")
    val url: String
)