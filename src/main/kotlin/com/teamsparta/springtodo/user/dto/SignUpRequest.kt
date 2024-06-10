package com.teamsparta.springtodo.user.dto

data class SignUpRequest (
    val email: String,
    val password: String,
    val nickname: String
)