package com.example.finalprojectpam.repository

import com.example.finalprojectpam.data.Resep
import kotlinx.coroutines.flow.Flow

interface RecipeRepository{
    fun getAllRecipeStream(): Flow<List<Resep>>

    fun getRecipeStream(id: Int): Flow<Resep?>

    suspend fun insertResep(resep: Resep)

    suspend fun deleteResep(resep: Resep)

    suspend fun updateResep(resep: Resep)
}
