package com.example.finalprojectpam.model

import kotlinx.serialization.Serializable

@Serializable
data class Login(
    val id_login: Int,
    val username: String,
    val email: String,
    val password: String
)
