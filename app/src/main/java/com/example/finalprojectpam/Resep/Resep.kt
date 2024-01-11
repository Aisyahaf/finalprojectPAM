package com.example.finalprojectpam.Resep

data class Resep(
    val id: String,
    val idProfil: String,
    val nama_resep: String,
    val bahan_resep: String,
    val deskripsi: String,
    val waktu: String,
    val porsi: String,
    val kategori: String
)
