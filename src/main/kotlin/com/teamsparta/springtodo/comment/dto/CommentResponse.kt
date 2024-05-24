package com.teamsparta.springtodo.comment.dto

data class CommentResponse(
    val id: Long,
    val authorName: String,
    val content: String,
    val password: String,
)
