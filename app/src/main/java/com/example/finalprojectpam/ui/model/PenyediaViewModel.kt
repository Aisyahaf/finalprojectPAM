package com.example.finalprojectpam.ui.model

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finalprojectpam.RecipeApplication

object PenyediaViewModel {
    val Factory = viewModelFactory {

        initializer {
            HomeViewModel(aplikasiResep().container.recipeRepository)
        }

        initializer {
            InsertViewModel(aplikasiResep().container.recipeRepository)
        }

        initializer {
            DetailsViewModel(
                createSavedStateHandle(),
                recipeRepository = aplikasiResep().container.recipeRepository)
        }
        initializer {
            EditViewModel(
                createSavedStateHandle(),
                recipeRepository =  aplikasiResep().container.recipeRepository
            )
        }

    }
}

fun CreationExtras.aplikasiResep():  RecipeApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RecipeApplication)