package com.example.booksearchapp.data.model.moshi


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResponse(
    @field:Json(name = "documents")
    val documents: List<Book>,
    @field:Json(name = "meta")
    val meta: Meta
)
