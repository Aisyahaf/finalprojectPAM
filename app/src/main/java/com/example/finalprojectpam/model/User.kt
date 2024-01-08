package com.example.finalprojectpam.model

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id_user: Int,
    val username: String,
    val password: String,
    val nama: String,
    val email: String,
    val jk: String,
    val tgl_lahir: String
)
