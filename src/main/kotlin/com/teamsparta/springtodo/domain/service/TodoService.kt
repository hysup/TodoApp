package com.teamsparta.springtodo.domain.service


import com.teamsparta.springtodo.domain.dto.CreateTodoRequest
import com.teamsparta.springtodo.domain.dto.TodoResponse
import com.teamsparta.springtodo.domain.dto.UpdateTodoRequest


interface TodoService {
    fun getAllTodoList() : List<TodoResponse>

    fun getTodoById(todoId: Long) : TodoResponse

    fun createTodo(request: CreateTodoRequest) : TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest) : TodoResponse

    fun deleteTodo(todoId: Long)


}