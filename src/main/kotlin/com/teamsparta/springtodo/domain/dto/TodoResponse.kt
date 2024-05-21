package com.teamsparta.springtodo.domain.dto

import java.sql.Timestamp
import java.time.ZonedDateTime

data class TodoResponse(
    val id : Long,
    val title: String,
    val content: String,
    val createdate: ZonedDateTime,
    val author: String
)
