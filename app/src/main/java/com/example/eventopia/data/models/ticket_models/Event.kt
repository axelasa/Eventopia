package com.example.eventopia.data.models.ticket_models

data class Event(
    val _embedded: EmbeddedX,
    val _links: LinksXX,
    val accessibility: Accessibility,
    val ageRestrictions: AgeRestrictions,
    val classifications: List<ClassificationX>,
    val dates: Dates,
    val id: String,
    val images: List<ImageXX>,
    val info: String,
    val locale: String,
    val name: String,
    val outlets: List<Outlet>,
    val pleaseNote: String,
    val products: List<Product>,
    val promoter: Promoter,
    val promoters: List<Promoter>,
    val sales: Sales,
    val seatmap: Seatmap,
    val test: Boolean,
    val ticketLimit: TicketLimit,
    val ticketing: Ticketing,
    val type: String,
    val url: String
)