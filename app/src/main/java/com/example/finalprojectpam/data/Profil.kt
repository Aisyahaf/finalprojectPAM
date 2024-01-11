package com.example.finalprojectpam.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblProfil")
data class Profil(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama_pengguna: String,
    val username: String,
    val email: String,
    val jenis_kelamin: String,
    val tanggal_lahir: String
)