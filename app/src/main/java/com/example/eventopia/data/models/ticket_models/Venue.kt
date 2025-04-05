package com.example.eventopia.data.models.ticket_models

data class Venue(
    val _links: Links,
    val accessibleSeatingDetail: String,
    val ada: Ada,
    val address: Address,
    val aliases: List<String>,
    val boxOfficeInfo: BoxOfficeInfo,
    val city: City,
    val country: Country,
    val dmas: List<Dma>,
    val generalInfo: GeneralInfo,
    val id: String,
    val images: List<ImageX>,
    val locale: String,
    val location: Location,
    val markets: List<Market>,
    val name: String,
    val parkingDetail: String,
    val postalCode: String,
    val social: Social,
    val state: State,
    val test: Boolean,
    val timezone: String,
    val type: String,
    val upcomingEvents: UpcomingEventsX,
    val url: String
)