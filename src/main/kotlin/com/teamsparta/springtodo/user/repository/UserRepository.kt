package com.teamsparta.springtodo.user.repository

import com.teamsparta.springtodo.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User,Long> {
    fun existsByEmail(email: String): Boolean

    fun findByEmail(email: String): User?
}