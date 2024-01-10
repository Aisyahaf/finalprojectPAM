package com.example.finalprojectpam.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblResep")
data class Resep(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama_resep: String,
    val bahan_resep: String,
    val deskripsi: String,
    val waktu: String,
    val porsi: String,
    val kategori: String,
)
