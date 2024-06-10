package com.teamsparta.springtodo.user.service

import com.teamsparta.springtodo.user.dto.*

interface UserService {
    fun signUp(request: SignUpRequest): UserResponse

    fun updateUserProfile(userId: Long, request: UpdateUserProfileRequest): UserResponse

    fun login(request: LoginRequest): LoginResponse
}