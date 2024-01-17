package com.example.booksearchapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.booksearchapp.data.repository.BookSearchRepository

class BookSearchViewModelProviderFactory(
    private val bookSearchRepository: BookSearchRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookSearchViewModel::class.java)) {
            return BookSearchViewModel(bookSearchRepository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
