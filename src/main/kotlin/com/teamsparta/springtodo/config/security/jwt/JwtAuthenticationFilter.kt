package com.teamsparta.springtodo.config.security.jwt

import com.teamsparta.springtodo.config.security.UserPrincipal
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter

@Component
class JwtAuthenticationFilter(
    private val jwtPlugin: JwtPlugin
): OncePerRequestFilter() { //모든 HTTP 요청에 대해 한 번씩 호출

    companion object {
        private val BEARER_PATTERN = Regex("^Bearer (.+)$") //문자열이 "Bearer <토큰값>" 형식인지를 검사하기 위한 정규식 패턴
    }

    override fun doFilterInternal(
        request: HttpServletRequest, //HTTP 요청에 대한 정보를 제공하는 객체이며 요청 URI, 헤더가 있음
        response: HttpServletResponse, // HTTP 응답에 대한 정보이며 클라이언트에게 보낼 응답 상태 코드, 헤더 등을 설정
        filterChain: FilterChain //다음 필터를 호출
    ) {
        val jwt = request.getBearerToken() // HTTP 요청에서 Bearer 토큰을 추출

        if (jwt != null) {
            jwtPlugin.validateToken(jwt) //JWT검증
                .onSuccess { //검증이 성공한 경우 사용자Id와 이메일을 추출하여 payload에 저장
                    val userId = it.payload.subject.toLong()
                    val email = it.payload.get("email", String::class.java)

                        val principal = UserPrincipal( //사용자의 주요정보를 담는 클래스
                            id = userId,
                            email = email
                        )
                        val authentication = JwtAuthenticationToken( //인증토큰
                            principal = principal,
                            details = WebAuthenticationDetailsSource().buildDetails(request)
                        )

                    SecurityContextHolder.getContext().authentication = authentication //인증된 사용자 정보를 설정
                }
        }
        filterChain.doFilter(request, response) //다음 필터 호출
    }
    private fun HttpServletRequest.getBearerToken(): String? {
        val headerValue = this.getHeader(HttpHeaders.AUTHORIZATION) ?: return null // Bearer {JWT}
        return BEARER_PATTERN.find(headerValue)?.groupValues?.get(1)
    }
}
