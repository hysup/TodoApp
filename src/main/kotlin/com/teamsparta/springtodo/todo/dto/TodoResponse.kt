package com.teamsparta.springtodo.todo.dto

import com.teamsparta.springtodo.config.ZonedDateTimeConverter
import jakarta.persistence.Convert

import java.time.ZonedDateTime


data class TodoResponse(
    val id: Long,
    val title: String,
    val content: String,
    val createdAt: ZonedDateTime,
    val author: String,
    val isComplete: Boolean
)
