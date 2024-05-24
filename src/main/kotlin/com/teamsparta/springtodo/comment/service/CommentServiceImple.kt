package com.teamsparta.springtodo.comment.service

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest
import com.teamsparta.springtodo.comment.repository.CommentRepository
import com.teamsparta.springtodo.todo.repository.TodoRepository
import com.teamsparta.springtodo.todo.service.TodoService
import org.springframework.stereotype.Service

@Service
class CommentServiceImple(
    private val commentRepository: CommentRepository
) : CommentService {
    override fun createComment(createCommentRequest: CreateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }

}


