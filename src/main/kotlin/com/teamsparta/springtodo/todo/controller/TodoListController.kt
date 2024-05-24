package com.teamsparta.springtodo.todo.controller


import com.teamsparta.springtodo.todo.dto.CreateTodoRequest
import com.teamsparta.springtodo.todo.dto.TodoResponse
import com.teamsparta.springtodo.todo.dto.UpdateTodoRequest
import com.teamsparta.springtodo.todo.service.TodoService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RequestMapping("/api/v1/todos")
@RestController
class TodoListController(
    private val todoService: TodoService

) {

    @GetMapping()
    fun getTodoList(): ResponseEntity<List<TodoResponse>> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(todoService.getAllTodoList())
    }

    @GetMapping("{todoId}")
    fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(todoService.getTodoById(todoId))

    }



    @PostMapping()
    fun createTodo(@RequestBody createTodoRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(todoService.createTodo(createTodoRequest))

    }

    @PutMapping("{todoId}")
    fun updateTodo(
        @PathVariable todoId: Long,
        @RequestBody updateTodoRequest: UpdateTodoRequest
    ): ResponseEntity<TodoResponse> {
        return ResponseEntity.status(HttpStatus.OK)
            .body(todoService.updateTodo(todoId, updateTodoRequest))

    }

    @DeleteMapping("{todoId}")
    fun deleteTodo(@PathVariable todoId: Long): ResponseEntity<Unit> {
        todoService.deleteTodo(todoId)
        return ResponseEntity
            .noContent()
            .build()

    }
}