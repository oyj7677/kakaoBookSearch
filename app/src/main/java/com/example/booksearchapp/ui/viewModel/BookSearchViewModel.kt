package com.example.booksearchapp.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.booksearchapp.data.model.gson.Book
import com.example.booksearchapp.data.model.gson.SearchResponse
import com.example.booksearchapp.data.repository.BookSearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookSearchViewModel(private val bookSearchRepository: BookSearchRepository) : ViewModel() {
    // Api
    private val _searchResult = MutableLiveData<SearchResponse>()
    val searchResult: LiveData<SearchResponse> get() = _searchResult

    fun searchBooks(query: String) = viewModelScope.launch(Dispatchers.IO) {
        val response = bookSearchRepository.searchBooks(query, "accuracy", 1, 50)
        if (response.isSuccessful) {
            response.body()?.let { body ->
                _searchResult.postValue(body)
            }
        }
    }

    // Room
    fun saveBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        bookSearchRepository.insertBooks(book)
    }

    fun deleteBook(book: Book) = viewModelScope.launch(Dispatchers.IO) {
        bookSearchRepository.deleteBooks(book)
    }

    val favoriteBooks = bookSearchRepository.getFavoriteBooks()
}
