package com.teamsparta.springtodo.todo.dto

data class CreateTodoRequest (
    val title: String,
    val content: String,
    val author: String
)
