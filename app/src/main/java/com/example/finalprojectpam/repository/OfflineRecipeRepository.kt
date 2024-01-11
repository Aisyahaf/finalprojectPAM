package com.example.finalprojectpam.repository

import com.example.finalprojectpam.data.Profil
import com.example.finalprojectpam.data.ProfilDao
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

class OfflineProfilRepository (private val profilDao: ProfilDao): ProfilRepository{
    override fun getAllProfilStream(): Flow<List<Profil>> = profilDao.getAllProfil()

    override fun getProfilStream(id: Int): Flow<Profil?> = profilDao.getProfil(id)

    override suspend fun insertProfil(profil: Profil) = profilDao.insert(profil)

    override suspend fun deleteProfil(profil: Profil) = profilDao.delete(profil)

    override suspend fun updateProfil(profil: Profil) = profilDao.update(profil)
}