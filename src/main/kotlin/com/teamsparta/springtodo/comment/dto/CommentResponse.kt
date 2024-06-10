package com.teamsparta.springtodo.comment.dto

import java.time.ZonedDateTime

data class CommentResponse(
    val id: Long,
    val authorName: String,
    val content: String,
    val password: String,
    val createdAt: ZonedDateTime,
)
