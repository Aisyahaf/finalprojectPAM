package com.example.finalprojectpam.repository

import com.example.finalprojectpam.data.Resep
import com.example.finalprojectpam.data.ResepDao
import kotlinx.coroutines.flow.Flow

class OfflineRecipeRepository (private val resepDao: ResepDao): RecipeRepository{
    override fun getAllRecipeStream(): Flow<List<Resep>> = resepDao.getAllResep()

    override fun getRecipeStream(id: Int): Flow<Resep?> = resepDao.getResep(id)

    override suspend fun insertResep(resep: Resep) = resepDao.insert(resep)

    override suspend fun deleteResep(resep: Resep) = resepDao.delete(resep)

    override suspend fun updateResep(resep: Resep) = resepDao.update(resep)
}