package com.teamsparta.springtodo.domain.dto

data class CreateTodoRequest (
    val title: String,
    val content: String,
    val author: String
)
