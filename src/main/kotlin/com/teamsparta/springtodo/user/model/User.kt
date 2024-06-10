package com.teamsparta.springtodo.user.model

import com.teamsparta.springtodo.user.dto.UserResponse
import jakarta.persistence.*


@Entity
@Table(name = "app_user")
class User (
    @Column(name = "email")
    val email: String,

    @Column(name = "password")
    val password: String,

    @Embedded
    var profile: Profile,

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    // 익숙하게 사용하기
    fun toResponse(): UserResponse {
        return UserResponse(
            id = this.id ?: -1,
            email = this.email,
            nickname = this.profile.nickname
        )
    }
}

//// User class 에 새로운 함수를 만든다.
//fun User.toResponse(): UserResponse {
//    return UserResponse(
//        id = this.id ?: -1,
//        email = email,
//        nickname = profile.nickname
//    )
//}
//
//// 새로운 전역 함수를 만든다.
//fun toResponse(){
//
//}


/*
table 관점에서 보기!

아래 코드로 인해서 user table 선언됨
@Table(name = "user")


column 은 어떤게 있느가?
id, email, password, nickmane, phone-number
 */