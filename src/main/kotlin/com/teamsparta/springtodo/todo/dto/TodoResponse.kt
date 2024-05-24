package com.teamsparta.springtodo.todo.dto

import java.time.ZonedDateTime

data class TodoResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdate: ZonedDateTime,
    val author: String,
    val isComplete: Boolean
)
