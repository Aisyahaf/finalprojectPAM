package com.example.finalprojectpam.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.Resep
import com.example.finalprojectpam.repository.RecipeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(private val resepRepository: RecipeRepository) : ViewModel() {
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val resepUIState: StateFlow<ResepUiState> = resepRepository.getAllRecipeStream()
        .filterNotNull()
        .map { ResepUiState(listResep = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ResepUiState()
        )

    data class ResepUiState(
        val listResep: List<Resep> = listOf()
    )
}

