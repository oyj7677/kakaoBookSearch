package com.example.booksearchapp.data.repository

import com.example.booksearchapp.data.model.gson.Book
import com.example.booksearchapp.data.model.gson.SearchResponse
import kotlinx.coroutines.flow.Flow
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
    fun getFavoriteBooks(): Flow<List<Book>>

    // DataStore
    suspend fun saveSortMode(mode: String)

    suspend fun getSortMode(): Flow<String>
}
