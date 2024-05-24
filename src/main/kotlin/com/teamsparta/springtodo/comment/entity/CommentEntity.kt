package com.teamsparta.springtodo.comment.entity

import com.teamsparta.springtodo.todo.entity.Todo
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "comment")
 class CommentEntity(

    @Column(name = "content")
    val content: String,

    @Column(name = "authorName")
    val authorName: String,

    @Column(name = "password")
    val password: String,

    @Column(nullable = false, updatable = false)
    var createdAt: ZonedDateTime,

    @ManyToOne
    val todo: Todo


){
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var id: Long? = null
 }

