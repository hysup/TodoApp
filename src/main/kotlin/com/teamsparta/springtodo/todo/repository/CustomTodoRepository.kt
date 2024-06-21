package com.teamsparta.springtodo.todo.repository


import com.teamsparta.springtodo.todo.entity.Todo


interface CustomTodoRepository {
    fun searchTodoListByTitle(title: String): List<Todo>

}