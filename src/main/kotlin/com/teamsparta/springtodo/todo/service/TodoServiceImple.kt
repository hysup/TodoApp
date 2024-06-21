package com.teamsparta.springtodo.todo.service

import com.teamsparta.springtodo.todo.dto.CompleteTodoRequest
import com.teamsparta.springtodo.todo.dto.CreateTodoRequest
import com.teamsparta.springtodo.todo.dto.TodoResponse
import com.teamsparta.springtodo.todo.dto.UpdateTodoRequest
import com.teamsparta.springtodo.todo.entity.Todo
import com.teamsparta.springtodo.todo.entity.TodoStatus
import com.teamsparta.springtodo.todo.repository.TodoRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.time.ZonedDateTime

@Service
class TodoServiceImple(
    private val todoRepository: TodoRepository,
) : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        return todoRepository.findAll().map { it.toResponse() }
    }

@Transactional
    override fun getTodoById(todoId: Long): TodoResponse {
        val todo =
            todoRepository.findById(todoId).orElseThrow { EntityNotFoundException("Todo not found with id $todoId") }
        return todo.toResponse()
    }

    @Transactional
    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        val todo = Todo(
            title = request.title,
            content = request.content,
            createdAt = ZonedDateTime.now(),
            author = request.author,
            isComplete = true
        )
        val savedTodo = todoRepository.save(todo)
        return savedTodo.toResponse()

    }

    @Transactional
    override fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse {
        var todo =
            todoRepository.findById(todoId).orElseThrow { EntityNotFoundException("Todo not found with id $todoId") }

        todo.title = request.title
        todo.content = request.content
        todo.isComplete = true

        val updatedTodo = todoRepository.save(todo)
        return updatedTodo.toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        todoRepository.findByIdOrNull(todoId) ?: throw EntityNotFoundException("TodoId")
        todoRepository.deleteById(todoId)

    }

    @Transactional
    override fun completeTodo(todoId: Long, request: CompleteTodoRequest): TodoResponse {
        val todo =
            todoRepository.findById(todoId).orElseThrow { EntityNotFoundException("Todo not found with id $todoId") }
        todo.isComplete = true
        return todo.toResponse()

    }

    override fun searchTodoList(title: String): List<TodoResponse>? {
        return todoRepository.searchTodoListByTitle(title).map { it.toResponse() }
    }


    }












