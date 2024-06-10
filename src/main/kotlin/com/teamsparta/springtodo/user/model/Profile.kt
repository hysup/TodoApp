package com.teamsparta.springtodo.user.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
class Profile (

    @Column(name = "nickname")
    val nickname: String,
//
//    @Column(name = "phone-number")
//    val phoneNumber: String
)


