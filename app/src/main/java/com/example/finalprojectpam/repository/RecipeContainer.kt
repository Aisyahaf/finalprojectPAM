package com.example.finalprojectpam.repository

import com.example.finalprojectpam.RecipeApplication
import com.example.finalprojectpam.data.DatabaseResep

interface AppContainer{
    val recipeRepository: RecipeRepository
    val profilRepository: ProfilRepository
}

class RecipeContainerDataApp(private val context: RecipeApplication): AppContainer{
    override val recipeRepository:RecipeRepository by lazy {
        OfflineRecipeRepository(DatabaseResep.getDatabase(context).resepDao())
    }

    override val profilRepository:ProfilRepository by lazy {
        OfflineProfilRepository(DatabaseResep.getDatabase(context).profilDao())
    }
}


