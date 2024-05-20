package com.teamsparta.springtodo.domain.entity

import com.teamsparta.springtodo.domain.dto.TodoResponse
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

    @Column(name = "author")
    val author: String
) {
    fun toResponse(): TodoResponse {
        return TodoResponse(
            id = this.id ?: 0L,
            title = this.title,
            content = this.content,
            author = this.author,
            createdate = this.createdAt
        )
    }
}

