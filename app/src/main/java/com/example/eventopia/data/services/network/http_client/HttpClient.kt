package com.example.eventopia.data.services.network.http_client
import com.example.eventopia.data.services.network.tiket.TicketApi
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.Retrofit
object HttpClient {
     private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://app.ticketmaster.com/")
         .addConverterFactory(GsonConverterFactory.create())
        .build()

    val ticketService: TicketApi = retrofit.create(TicketApi::class.java)
}