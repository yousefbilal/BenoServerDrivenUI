package com.example.benoserverdrivenui

import kotlinx.serialization.Serializable

@Serializable
data class Product(
    val id: Int,
    val imageUrl: String,
    val price: String,
    val name: String,
    val type: String,
    val rating: Float,
    val ratingCount: Int,
    val description: String
)