package com.teamsparta.springtodo.comment.controller

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest
import com.teamsparta.springtodo.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.status
import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todo/{todoId}/comments")
@RestController
class CommentController (
private val commentService: CommentService
) {

    @PostMapping()
    fun createComment(@PathVariable todoId: Long,
                      @RequestBody createcommentrequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(todoId, createcommentrequest))


    }

    @PutMapping("/{commentId}")
    fun updateComment(@PathVariable commentId: Long,
                      @RequestBody updatecommentrequest: UpdateCommentRequest
    ): ResponseEntity<CommentResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .body(commentService.updateComment(commentId, updatecommentrequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long): ResponseEntity<Unit> {
        commentService.deleteComment(commentId)
        return ResponseEntity
            .noContent()
            .build()
    }
    }



