package com.teamsparta.springtodo.config.security.jwt

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.security.Keys
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.Instant
import java.util.*


@Component
class JwtPlugin(
@Value("\${auth.jwt.issuer}") private val issuer: String,
@Value("\${auth.jwt.secret}") private val secret: String,           //보안상의 이유로 companion object가 아닌 yml에 따로 빼놓은 것을 주입
@Value("\${auth.jwt.accessTokenExpiration}") private val accessTokenExpiration: Long,
) {


    fun validateToken(jwt: String) : Result<Jws<Claims>> {
        return kotlin.runCatching {
            val key = Keys.hmacShaKeyFor(issuer.toByteArray(StandardCharsets.UTF_8))
            Jwts.parser().verifyWith(key).build().parseSignedClaims(jwt)

        }
    }

    fun generateAccessToken(subject: String, email: String): String {              //generateToken 함수 호출

        return generateToken(subject, email,  Duration.ofHours(accessTokenExpiration)) ////subject와 이메일 기반으로 엑세스 토큰 생성 후 반환
    }

    private fun generateToken(subject: String,email:String,expirationPeriod: Duration): String {
        val claims: Claims = Jwts.claims() //JWT의 클레임(claim) 세트를 초기화
            .add(mapOf( "email" to email)) //사용자 지정 클레임을 추가 - 이메일
            .build()

        val key = Keys.hmacShaKeyFor(secret.toByteArray(StandardCharsets.UTF_8))
        val now = Instant.now()

        return Jwts.builder()
            .subject(subject) // 주제
            .issuer(issuer)  //발행자(issuer)
            .issuedAt(Date.from(now)) //토큰 생성일자
            .expiration(Date.from(now.plus(expirationPeriod))) //만료기간
            .claims(claims) //클레임
            .signWith(key) // 생성한 키를 사용하여 토큰을 서명
            .compact() //JWT 문자열을 생성하고 반환
    }
}