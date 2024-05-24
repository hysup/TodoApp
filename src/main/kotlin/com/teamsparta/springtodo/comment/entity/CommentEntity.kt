package com.teamsparta.springtodo.comment.entity

import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "comment")
 class CommentEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

   @Column(name = "content")
    val content: String,

    @Column(name = "authorId")
    val authorName: String,

    @Column(name = "password")
    val password: String,

     @Column(nullable = false, updatable = false)
     var createdAt: ZonedDateTime


)

