package com.teamsparta.springtodo.comment.repository

import com.teamsparta.springtodo.comment.entity.CommentEntity

import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<CommentEntity, Long> {
}