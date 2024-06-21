package com.teamsparta.springtodo.todo.repository

import com.querydsl.core.BooleanBuilder
import com.teamsparta.springtodo.config.querydsl.QueryDslSupport
import com.teamsparta.springtodo.todo.entity.QTodo
import com.teamsparta.springtodo.todo.entity.Todo
import org.springframework.stereotype.Repository


@Repository
class TodoRepositoryImpl: QueryDslSupport(),CustomTodoRepository {

    private val todo = QTodo.todo
    override fun searchTodoListByTitle(title: String): List<Todo> {
        return queryFactory.selectFrom(todo)
            .where(todo.title.containsIgnoreCase(title))
            .fetch()
    }

    }
