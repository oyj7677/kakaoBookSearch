package com.example.booksearchapp.data.repository

import androidx.lifecycle.LiveData
import com.example.booksearchapp.data.model.gson.Book
import com.example.booksearchapp.data.model.gson.SearchResponse
import retrofit2.Response

interface BookSearchRepository {
    suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse>

    // Room
    suspend fun insertBooks(book: Book)
    suspend fun deleteBooks(book: Book)
    fun getFavoriteBooks(): LiveData<List<Book>>
}
