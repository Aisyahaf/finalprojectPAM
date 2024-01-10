package com.example.finalprojectpam.ui.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.repository.RecipeRepository
import com.example.finalprojectpam.ui.screen.ItemEditDestination
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

//package com.example.finalprojectpam.ui.model




class EditViewModel(
    savedStateHandle: SavedStateHandle,
    private val recipeRepository: RecipeRepository
) : ViewModel(){
    var resepUiState by mutableStateOf(InsertUiState())
        private set

    private val itemId: Int = checkNotNull(savedStateHandle[ItemEditDestination.resepIdArg])

    init {
        viewModelScope.launch {
            resepUiState = recipeRepository.getRecipeStream(itemId)
                .filterNotNull()
                .first()
                .toUiStateResep(true)
        }
    }

    suspend fun updateResep(){
        if (validasiInput(resepUiState.insertUiEvent)){
            recipeRepository.updateResep(resepUiState.insertUiEvent.toResep())
        }else{
            println("Data tidak valid")
        }
    }

    fun updateUiState(insertUiEvent: InsertUiEvent){
        resepUiState = InsertUiState(insertUiEvent = insertUiEvent, isEntryValid = validasiInput())
    }

    private fun validasiInput(uiState: InsertUiEvent = resepUiState.insertUiEvent): Boolean{
        return with(uiState){
            nama_resep.isNotBlank() && bahan_resep.isNotBlank() && deskripsi.isNotBlank() && waktu.isNotBlank() && porsi.isNotBlank() && kategori.isNotBlank()
        }
    }

}