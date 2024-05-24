package com.teamsparta.springtodo.comment.dto

data class UpdateCommentRequest(
    val authorName: String,
    val content: String,
    val password: String
)
