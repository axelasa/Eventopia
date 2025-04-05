package com.example.eventopia.data.models.ticket_models

data class EmbeddedX(
    val attractions: List<Attraction>,
    val venues: List<Venue>
)