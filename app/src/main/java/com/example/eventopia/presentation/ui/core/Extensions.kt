package com.example.eventopia.presentation.ui.core

import com.example.eventopia.data.models.ticket_models.Event
import com.example.eventopia.presentation.ui.features.explore_events.model.EventSummary

fun Event.toEventSummary():EventSummary{
    return EventSummary(name=name,
        promoters =promoters.map { it.name }.joinToString {""},
        imageUrl = images.map { it.url }.last()
        )
}