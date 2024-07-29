package com.ecoapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ecoapp.R
import com.ecoapp.data.model.EcoItem
import com.ecoapp.data.model.EcoDetail
import com.ecoapp.domain.usecase.FetchEcoDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCarouselItemsUseCase: FetchEcoDataUseCase,
) : ViewModel() {


    private val _ecoItems = MutableStateFlow<List<EcoItem>>(emptyList())
    val ecoItems: StateFlow<List<EcoItem>> get() = _ecoItems.asStateFlow()

    private val _filteredItems = MutableStateFlow<List<EcoDetail>>(emptyList())
    val filteredItems: StateFlow<List<EcoDetail>> get() = _filteredItems.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> get() = _errorMessage.asStateFlow()

    init {
        fetchEcoData()
    }

    private fun fetchEcoData() {
        viewModelScope.launch {
            try {
                val items = getCarouselItemsUseCase.execute()
                _ecoItems.value = items
                if (items.isNotEmpty()) {
                    updateFilteredItems(0, null)
                }
            } catch (e: Exception) {
                handleFetchError(e)
            }
        }
    }
    private fun handleFetchError(e: Exception) {
        _errorMessage.value = "${e.message}"
        _ecoItems.value = emptyList()
    }
    fun updateFilteredItems(pageIndex: Int, query: String?) {
        val items = _ecoItems.value.getOrNull(pageIndex)?.subItems ?: emptyList()
        _filteredItems.value = if (query.isNullOrEmpty()) {
            items
        } else {
            items.filter {
                it.title.contains(query, ignoreCase = true) || it.subTitle.contains(
                    query,
                    ignoreCase = true
                )
            }
        }
    }

    fun getItemCountsForPage(pageIndex: Int): List<Int> {
        return _ecoItems.value.getOrNull(pageIndex)?.subItems?.size?.let { listOf(it) } ?: emptyList()
    }

    fun getTopCharactersForPage(pageIndex: Int): List<Pair<Char, Int>> {
        val item = _ecoItems.value.getOrNull(pageIndex) ?: return emptyList()
        return calculateTopCharacters(item.subItems)
    }

    private fun calculateTopCharacters(subItems: List<EcoDetail>): List<Pair<Char, Int>> {
        val characterCount = mutableMapOf<Char, Int>()

        val allText = subItems.flatMap { listOf(it.title, it.subTitle) }.joinToString(" ")

        allText.forEach { char ->
            if (char.isLetter()) {
                characterCount[char] = characterCount.getOrDefault(char, 0) + 1
            }
        }

        return characterCount.entries
            .sortedByDescending { it.value }
            .take(3)
            .map { it.key to it.value }
    }
}
