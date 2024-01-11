package com.example.finalprojectpam.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ResepDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(resep: Resep)

    @Update
    suspend fun update(resep: Resep)

    @Delete
    suspend fun delete(resep: Resep)

    @Query("SELECT * from tblResep WHERE id = :id")
    fun getResep(id: Int): Flow<Resep>

    @Query("SELECT * from tblResep ORDER BY nama_resep ASC")
    fun getAllResep(): Flow<List<Resep>>
}

interface ProfilDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(profil: Profil)

    @Update
    suspend fun update(profil: Profil)

    @Delete
    suspend fun delete(profil: Profil)

    @Query("SELECT * from tblProfil WHERE id = :id")
    fun getProfil(id: Int): Flow<Profil>

    @Query("SELECT * from tblProfil ORDER BY nama_pengguna ASC")
    fun getAllProfil(): Flow<List<Profil>>
}