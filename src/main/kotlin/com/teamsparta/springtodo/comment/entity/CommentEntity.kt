package com.teamsparta.springtodo.comment.entity

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.todo.entity.Todo
import jakarta.persistence.*
import java.time.ZonedDateTime

@Entity
@Table(name = "comment")
 class CommentEntity(

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   var id: Long? = null,

    @Column(name = "content")
    var content: String,

    @Column(name = "authorName")
    val authorName: String,

    @Column(name = "password")
    val password: String,

    @Column(nullable = false, updatable = false)
    var createdAt: ZonedDateTime,

   @Column(nullable = false)
   var updatedAt: ZonedDateTime? = null,

    @ManyToOne
    val todo: Todo


){
   fun toResponse(): CommentResponse {
      return CommentResponse(
         id = this.id ?: throw IllegalStateException("Comment Id cannot be null"),
         authorName = this.authorName,
         content = this.content,
         createdAt = this.createdAt,
         password = this.password,
      )

 }
}



