package com.teamsparta.springtodo.comment.dto

import jakarta.persistence.Id

data class CreateCommentRequest(
    val authorName: String,
    val content: String,
    val password: String

)
