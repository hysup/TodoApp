package com.teamsparta.springtodo.domain.service

import com.teamsparta.springtodo.domain.dto.CreateTodoRequest
import com.teamsparta.springtodo.domain.dto.TodoResponse
import com.teamsparta.springtodo.domain.dto.UpdateTodoRequest
import com.teamsparta.springtodo.domain.entity.Todo
import com.teamsparta.springtodo.domain.repository.TodoRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

import java.time.ZonedDateTime

@Service
class TodoServiceImple(
    private val todoRepository: TodoRepository
) : TodoService {
    override fun getAllTodoList(): List<TodoResponse> {
        return todoRepository.findAll().map { it.toResponse() }
    }


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
            author = request.author
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

        val updatedTodo = todoRepository.save(todo)
        return updatedTodo.toResponse()
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw EntityNotFoundException("TodoId")
        todoRepository.deleteById(todoId)

    }


}

