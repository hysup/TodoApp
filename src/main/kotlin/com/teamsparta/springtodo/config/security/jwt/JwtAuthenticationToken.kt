package com.teamsparta.springtodo.config.security.jwt

import com.teamsparta.springtodo.config.security.UserPrincipal
import org.springframework.security.authentication.AbstractAuthenticationToken
import org.springframework.security.web.authentication.WebAuthenticationDetails
import java.io.Serializable

class JwtAuthenticationToken(
    private val principal: UserPrincipal,
    details: WebAuthenticationDetails,
): AbstractAuthenticationToken(principal.authorities),Serializable {

    init{
        super.setAuthenticated(true)
        super.setDetails(details)
    }

    override fun getCredentials() =null


    override fun getPrincipal() = principal

    override fun isAuthenticated(): Boolean {
        return true

    }
}