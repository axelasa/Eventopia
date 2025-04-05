package com.example.eventopia.data.models.ticket_models

data class ExternalLinks(
    val facebook: List<Facebook>,
    val homepage: List<Homepage>,
    val instagram: List<Instagram>,
    val twitter: List<Twitter>,
    val wiki: List<Wiki>,
    val youtube: List<Youtube>
)