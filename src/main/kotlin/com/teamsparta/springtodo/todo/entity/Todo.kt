package com.teamsparta.springtodo.todo.entity

import com.teamsparta.springtodo.todo.dto.TodoResponse
import jakarta.persistence.*

import java.time.ZonedDateTime

@Entity
@Table(name = "todos")
class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "title")
    var title: String,

    @Column(name = "content")
    var content: String,

    @Column(nullable = false, updatable = false)
    val createdAt: ZonedDateTime,

    @Column(nullable = false)
    var isComplete: Boolean = false,

    @Column(name = "author")
    val author: String
) {
    fun toResponse(): TodoResponse {
        return TodoResponse(
            id = this.id ?: 0L,
            title = this.title,
            content = this.content,
            author = this.author,
            isComplete = this.isComplete,
            createdate = this.createdAt
        )
    }
}

