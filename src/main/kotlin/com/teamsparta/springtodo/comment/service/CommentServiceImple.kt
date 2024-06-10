package com.teamsparta.springtodo.comment.service


import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest
import com.teamsparta.springtodo.comment.entity.CommentEntity
import com.teamsparta.springtodo.comment.repository.CommentRepository
import com.teamsparta.springtodo.exception.ModelNotfoundException
import com.teamsparta.springtodo.todo.repository.TodoRepository
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

    override fun createComment(todoId: Long, createCommentRequest: CreateCommentRequest): CommentResponse {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotfoundException("Todo", todoId)

        val commentEntity = CommentEntity(
            content = createCommentRequest.content,
            authorName = createCommentRequest.authorName,
            todo = todo,
            password = createCommentRequest.password,
            createdAt = ZonedDateTime.now()

        )
        return commentRepository.save(commentEntity).toResponse()


    }

    @Transactional
    override fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse {
       val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotfoundException("Comment", commentId)

        comment.content = request.content
        comment.updatedAt = ZonedDateTime.now()

        return comment.toResponse()


    }

    override fun deleteComment(commentId: Long) {
        val comment = commentRepository.findByIdOrNull(commentId) ?: throw ModelNotfoundException("Comment", commentId)

        commentRepository.delete(comment)
    }

}


