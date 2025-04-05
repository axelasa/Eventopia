package com.example.eventopia.presentation.ui.features.explore_events.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.eventopia.data.models.dto_models.TaskError
import com.example.eventopia.data.models.dto_models.TaskResult
import com.example.eventopia.data.models.dto_models.TaskSuccess
import com.example.eventopia.data.models.ticket_models.Event
import com.example.eventopia.data.repositories.EventRepository
import com.example.eventopia.presentation.ui.core.toEventSummary
import com.example.eventopia.presentation.ui.features.explore_events.model.EventSummary
import com.example.eventopia.presentation.ui.features.explore_events.model.*

class ExploreViewModel(application: Application, private val eventRepository: EventRepository) :
    AndroidViewModel(application) {
    private var page = 0
    private val eventList: MutableList<EventSummary> = mutableListOf<EventSummary>()

    val events = eventList

    private var state: ExploreState = LoadedExploreState()

    suspend fun loadEvents() {
        if (state !is LoadedExploreState) return

        try {
            state = LoadingExploreState()
            val fetchedResults: TaskResult<List<Event>> =
                eventRepository.fetchEvent(page = page, 20)
            when (fetchedResults) {
                is TaskError<*> -> TODO()
                is TaskSuccess<List<Event>> -> {
                    eventList.addAll(fetchedResults.data.map { it.toEventSummary() })
                    page++
                }
            }

        } finally {
            state = LoadedExploreState()

        }
    }
}