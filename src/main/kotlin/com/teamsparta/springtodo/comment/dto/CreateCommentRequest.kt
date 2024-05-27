package com.teamsparta.springtodo.comment.dto



data class CreateCommentRequest(
    val authorName: String,
    val content: String,
    val password: String

)
