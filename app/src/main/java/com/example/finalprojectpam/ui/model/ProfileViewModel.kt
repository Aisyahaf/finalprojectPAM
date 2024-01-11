package com.example.finalprojectpam.ui.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectpam.data.Profil
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class ProfileViewModel (private val profilRepository: ProfilRepository) : ViewModel() {
    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
    }

    val resepUIState: StateFlow<ProfilUiState> = profilRepository.getAllProfilStream()
        .filterNotNull()
        .map { ProfilUiState(listProfil = it.toList()) }
        .stateIn(scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = ProfilUiState()
        )

    data class ProfilUiState(
        val listProfil: List<Profil> = listOf()
    )
}