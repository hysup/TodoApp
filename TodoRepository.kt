package com.teamsparta.springtodo.domain.repository

import com.teamsparta.springtodo.domain.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository

interface TodoRepository: JpaRepository<Todo, Long> {

}

