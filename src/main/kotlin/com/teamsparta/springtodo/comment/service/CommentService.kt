package com.teamsparta.springtodo.comment.service

import com.teamsparta.springtodo.comment.dto.CommentResponse
import com.teamsparta.springtodo.comment.dto.CreateCommentRequest
import com.teamsparta.springtodo.comment.dto.UpdateCommentRequest



interface CommentService {

    fun createComment(createCommentRequest: CreateCommentRequest): CommentResponse

    fun updateComment(commentId: Long, request: UpdateCommentRequest): CommentResponse

    fun deleteComment(commentId: Long)
}
