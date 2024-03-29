package com.example.booksearchapp.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.booksearchapp.R
import com.example.booksearchapp.databinding.FragmentSettingsBinding
import com.example.booksearchapp.ui.viewModel.BookSearchViewModel
import com.example.booksearchapp.util.Sort
import kotlinx.coroutines.launch

class SettingsFragment : Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var bookSearchViewModel: BookSearchViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bookSearchViewModel =(activity as MainActivity).bookSearchViewModel

        saveSettings()
        loadSettings()
    }

    private fun loadSettings() {
        binding.rgSort.setOnCheckedChangeListener { _, checkedId ->
            val value = when(checkedId) {
                R.id.rb_accuracy -> Sort.ACCURACY.value
                R.id.rb_latest -> Sort.LATEST.value
                else -> Sort.ACCURACY.value
            }
            bookSearchViewModel.saveSortMode(value)
        }
    }

    private fun saveSettings() {
        lifecycleScope.launch {
            val buttonId = when(bookSearchViewModel.getSortMode()) {
                Sort.ACCURACY.value -> R.id.rb_accuracy
                Sort.LATEST.value -> R.id.rb_latest
                else -> return@launch
            }
            binding.rgSort.check(buttonId)
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}
