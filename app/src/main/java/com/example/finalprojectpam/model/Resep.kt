package com.example.finalprojectpam.model

import kotlinx.serialization.Serializable

@Serializable
data class Resep(
    val id: Int,
    val nama_resep: String,
    val bahan_resep: String,
    val deskripsi: String,
    val waktu: String,
    val porsi: String,
    val kategori: String,
)
