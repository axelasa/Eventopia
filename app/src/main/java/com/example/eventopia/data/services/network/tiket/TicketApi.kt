package com.example.eventopia.data.services.network.tiket

import com.example.eventopia.data.models.ticket_models.GetAllEventsResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface TicketApi {
    @GET("discovery/v2/events.json")
    suspend fun fetchEvents(@QueryMap params:Map<String,String>): Response<GetAllEventsResponse>
}