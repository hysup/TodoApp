package com.teamsparta.springtodo.comment.repository

import org.hibernate.annotations.Comment
import org.hibernate.annotations.Comments
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {
}