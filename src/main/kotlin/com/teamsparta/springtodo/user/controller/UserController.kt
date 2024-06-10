package com.teamsparta.springtodo.user.controller

import com.teamsparta.springtodo.user.dto.*
import com.teamsparta.springtodo.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController (
    private val userService: UserService
) {
    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<LoginResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.login(loginRequest))
    }

    @PostMapping("/signup")
    fun signup(@RequestBody signUpRequest: SignUpRequest): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.signUp(signUpRequest))
    }

    @PutMapping("/users/{userId}/profile")
    fun updateUserProfile(@PathVariable userId: Long,
                          @RequestBody updateUserProfileRequest: UpdateUserProfileRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updateUserProfile(userId, updateUserProfileRequest))
    }
}