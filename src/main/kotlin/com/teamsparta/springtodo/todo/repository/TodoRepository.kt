package com.teamsparta.springtodo.todo.repository

import com.teamsparta.springtodo.todo.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long>,CustomTodoRepository {


}

