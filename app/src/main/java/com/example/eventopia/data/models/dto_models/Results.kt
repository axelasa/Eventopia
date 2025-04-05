package com.example.eventopia.data.models.dto_models

import java.lang.Exception

sealed class TaskResult <T>{

}

class TaskSuccess<T>(val data:T) : TaskResult <T>() {

}

class TaskError<T>(
    val message:String,
    val exception: Exception
) : TaskResult <T>() {

}

