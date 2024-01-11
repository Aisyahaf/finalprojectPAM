package com.example.finalprojectpam.ui.model

import com.example.finalprojectpam.data.Resep
import com.example.finalprojectpam.repository.RecipeRepository
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class InsertViewModel(private val recipeRepository: RecipeRepository): ViewModel(){
//    Berisi Status  Siswa saat ini

    var uiStateResep by mutableStateOf(InsertUiState())
        private set

    /*Fungsi untuk memvalidasi input*/
    private fun validasiInput(uiState: InsertUiEvent = uiStateResep.insertUiEvent): Boolean {
        return with(uiState){
            nama_resep.isNotBlank() && bahan_resep.isNotBlank() && deskripsi.isNotBlank() && waktu.isNotBlank() && porsi.isNotBlank() && kategori.isNotBlank()
        }
    }

    fun updateUiState(insertUiEvent: InsertUiEvent){
        uiStateResep =
            InsertUiState(insertUiEvent = insertUiEvent, isEntryValid = validasiInput(insertUiEvent))
    }

    /* Fungsi untuk menyimpan data yang di-entry */
    suspend fun saveResep(){
        if (validasiInput()){
            recipeRepository.insertResep(uiStateResep.insertUiEvent.toResep())
        }
    }
}

data class InsertUiState(
    val insertUiEvent: InsertUiEvent = InsertUiEvent(),
    val isEntryValid: Boolean = false
)

data class InsertUiEvent(
    val id: Int = 0,
    val nama_resep: String = "",
    val bahan_resep: String = "",
    val deskripsi: String = "",
    val waktu: String = "",
    val porsi: String = "",
    val kategori: String = "",
)

fun InsertUiEvent.toResep(): Resep = Resep(
    id = id,
    nama_resep = nama_resep,
    bahan_resep = bahan_resep,
    deskripsi = deskripsi,
    waktu = waktu,
    porsi = porsi,
    kategori = kategori
)

fun Resep.toUiStateResep(isEntryValid: Boolean = false): InsertUiState = InsertUiState(
    insertUiEvent = toInsertUiEvent(),
    isEntryValid = isEntryValid
)

fun Resep.toInsertUiEvent(): InsertUiEvent = InsertUiEvent(
    id = id,
    nama_resep = nama_resep,
    bahan_resep = bahan_resep,
    deskripsi = deskripsi,
    waktu = waktu,
    porsi = porsi,
    kategori = kategori
)

