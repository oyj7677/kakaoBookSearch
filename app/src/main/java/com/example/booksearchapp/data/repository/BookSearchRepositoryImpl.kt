package com.example.booksearchapp.data.repository

import android.util.Log
import com.example.booksearchapp.data.api.RetrofitInstance.api
import com.example.booksearchapp.data.model.gson.SearchResponse
import com.example.booksearchapp.util.Constants.API_KEY
import retrofit2.Response

class BookSearchRepositoryImpl : BookSearchRepository {
    override suspend fun searchBooks(
        query: String,
        sort: String,
        page: Int,
        size: Int
    ): Response<SearchResponse> {
        return api.searchBooks(query = query, sort = sort, page = page, size = size)
    }
}
