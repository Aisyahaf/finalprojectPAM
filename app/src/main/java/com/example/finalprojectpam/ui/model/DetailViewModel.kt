package com.example.finalprojectpam.ui.model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.repository.RecipeRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val recipeRepository: RecipeRepository
): ViewModel(){
    private val resepId: Int = checkNotNull(savedStateHandle[DetailsDestination.resepIdArg])
    val uiState: StateFlow<ItemDetailUiState> =
        recipeRepository.getRecipeStream(resepId)
            .filterNotNull()
            .map {
                ItemDetailUiState(insertUiEvent = it.toInsertUiEvent())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = ItemDetailUiState()
            )

    suspend fun deleteItem(){
        recipeRepository.deleteResep(uiState.value.insertUiEvent.toResep())
    }

    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

data class ItemDetailUiState(
    val outOfStock: Boolean = true,
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
)