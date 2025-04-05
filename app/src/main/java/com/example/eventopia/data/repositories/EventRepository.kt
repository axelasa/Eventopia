package com.example.eventopia.data.repositories

import com.example.eventopia.data.models.dto_models.TaskError
import com.example.eventopia.data.models.dto_models.TaskResult
import com.example.eventopia.data.models.dto_models.TaskSuccess
import com.example.eventopia.data.models.ticket_models.Event
import com.example.eventopia.data.services.network.tiket.TicketApi
import retrofit2.HttpException

interface  EventRepository{
    suspend fun fetchEvent(page:Int, pageSize:Int):TaskResult<List<Event>>
}

class EventRepositoryImpl(private val ticketApiService: TicketApi,
                          private val apikey:String ):EventRepository{
    override suspend fun fetchEvent(page: Int, pageSize: Int): TaskResult<List<Event>> {
       try {
           val response = ticketApiService.fetchEvents(mapOf(
               "apikey" to apikey,
               "page" to page,
               "size" to pageSize
           )).execute()
           if(!response.isSuccessful){
               return TaskError(
                   response.message(),
                   HttpException(response),)
           }
           val data = response.body()!!
           return TaskSuccess(data._embedded.events)
       }catch (e:Exception){
         return TaskError(e.message?: "Something went Wrong",e)
       }
    }
}