package com.teamsparta.springtodo.user.exception

data class InvalidCredentialException(
    override val message: String? = "The credentials is invalid"

): RuntimeException(message)
