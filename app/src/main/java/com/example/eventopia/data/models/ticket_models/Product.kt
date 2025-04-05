package com.example.eventopia.data.models.ticket_models

data class Product(
    val classifications: List<ClassificationX>,
    val id: String,
    val name: String,
    val type: String,
    val url: String
)