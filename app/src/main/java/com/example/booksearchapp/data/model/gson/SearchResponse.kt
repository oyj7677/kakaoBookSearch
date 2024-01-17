package com.example.booksearchapp.data.model.gson


import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName("documents")
    val documents: List<Book>,
    @SerializedName("meta")
    val meta: Meta
)