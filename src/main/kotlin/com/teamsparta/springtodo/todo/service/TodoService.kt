package com.teamsparta.springtodo.todo.service


import com.teamsparta.springtodo.todo.dto.CompleteTodoRequest
import com.teamsparta.springtodo.todo.dto.CreateTodoRequest
import com.teamsparta.springtodo.todo.dto.TodoResponse
import com.teamsparta.springtodo.todo.dto.UpdateTodoRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable


interface TodoService {
    fun getAllTodoList() : List<TodoResponse>

    fun getTodoById(todoId: Long) : TodoResponse

    fun createTodo(request: CreateTodoRequest) : TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest) : TodoResponse

    fun deleteTodo(todoId: Long)

    fun completeTodo(todoId: Long, request: CompleteTodoRequest) : TodoResponse

    fun searchTodoList(title: String): List<TodoResponse>?




}