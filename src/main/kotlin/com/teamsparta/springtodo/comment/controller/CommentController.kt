package com.teamsparta.springtodo.comment.controller

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest
import com.teamsparta.springtodo.comment.service.CommentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize

import org.springframework.web.bind.annotation.*

@RequestMapping("/api/v1/todos/{todoId}/comments")
@RestController
class CommentController(
    private val commentService: CommentService
) {

    @PostMapping()
    fun createComment(
        @PathVariable todoId: Long,
        @RequestBody createCommentRequest: CreateCommentRequest
    ): ResponseEntity<CommentResponse> {
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(commentService.createComment(todoId, createCommentRequest))


    }

    @PutMapping("/{commentId}")
    fun updateComment(
        @PathVariable commentId: Long,
        @RequestBody updateCommentRequest: UpdateCommentRequest, @PathVariable todoId: String
    ): ResponseEntity<CommentResponse> {

        return ResponseEntity.status(HttpStatus.OK)
            .body(commentService.updateComment(commentId, updateCommentRequest))
    }

    @DeleteMapping("/{commentId}")
    fun deleteComment(@PathVariable commentId: Long, @PathVariable todoId: String): ResponseEntity<Unit> {
        commentService.deleteComment(commentId)
        return ResponseEntity
            .noContent()
            .build()
    }
}



