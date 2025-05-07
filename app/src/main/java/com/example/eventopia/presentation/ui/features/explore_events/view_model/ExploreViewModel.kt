package com.example.eventopia.presentation.ui.features.explore_events.view_model

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.eventopia.data.models.dto_models.TaskError
import com.example.eventopia.data.models.dto_models.TaskResult
import com.example.eventopia.data.models.dto_models.TaskSuccess
import com.example.eventopia.data.models.ticket_models.Event
import com.example.eventopia.data.repositories.EventRepository
import com.example.eventopia.presentation.ui.core.toEventSummary
import com.example.eventopia.presentation.ui.features.explore_events.model.EventSummary
import com.example.eventopia.presentation.ui.features.explore_events.model.*
import kotlinx.coroutines.launch

class ExploreViewModel(application: Application, private val eventRepository: EventRepository) :
    AndroidViewModel(application) {
    private var page = 0
    private val _eventList = MutableLiveData<List<EventSummary>> ()
    val eventList : LiveData<List<EventSummary>> =_eventList
    val events = eventList
    private val _toastMessage = MutableLiveData<String>()
     val toastMessage : LiveData<String> = _toastMessage
    private var state: ExploreState = LoadedExploreState

    init {
        viewModelScope.launch() {
            loadEvents()
        }
    }

     suspend fun loadEvents() {
        if (state !is LoadedExploreState) return

        try {
            state = LoadingExploreState
            val fetchedResults: TaskResult<List<Event>> =
                eventRepository.fetchEvent(page = page, 20)
            when (fetchedResults) {
                is TaskError<*> -> _toastMessage.value = fetchedResults.message
                is TaskSuccess<List<Event>> -> {
                    _eventList.value = (fetchedResults.data.map { it.toEventSummary() })
                    page++
                }
            }

        } finally {
            state = LoadedExploreState

        }
    }
}