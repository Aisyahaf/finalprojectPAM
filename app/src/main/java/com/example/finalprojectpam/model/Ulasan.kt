package com.example.finalprojectpam.model

import kotlinx.serialization.Serializable

@Serializable
data class Ulasan(
    val id_ul: Int,
    val rating: Int,
    val ulasan: String
)
