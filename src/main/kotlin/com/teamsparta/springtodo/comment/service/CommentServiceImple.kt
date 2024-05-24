package com.teamsparta.springtodo.comment.service

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest
import com.teamsparta.springtodo.comment.entity.CommentEntity
import com.teamsparta.springtodo.comment.repository.CommentRepository
import com.teamsparta.springtodo.todo.repository.TodoRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.ZonedDateTime

@Service
class CommentServiceImple(
    private val commentRepository: CommentRepository,
    private val todoRepository: TodoRepository
) : CommentService {

    @Transactional

//     val foundtodoId:Any= todoRepository.findByIdOrNull(todoId) ?: throw EntityNotFoundException("todoId", todoId)

    override fun createComment(todoId: Long, createCommentRequest: CreateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
        TODO("Not yet implemented")
    }

    override fun deleteComment(commentId: Long) {
        TODO("Not yet implemented")
    }

}


