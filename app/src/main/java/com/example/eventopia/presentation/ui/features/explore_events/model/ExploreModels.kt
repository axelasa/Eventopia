package com.example.eventopia.presentation.ui.features.explore_events.model

data class EventSummary(
    val name:String,
    val promoters:String,
    val imageUrl:String,

    )

sealed class ExploreState

data object LoadingExploreState : ExploreState()


data object LoadedExploreState : ExploreState()