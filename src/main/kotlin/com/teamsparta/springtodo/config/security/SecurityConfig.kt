package com.teamsparta.springtodo.config.security

import com.teamsparta.springtodo.config.security.jwt.CustomAuthenticationEntryPoint
import com.teamsparta.springtodo.config.security.jwt.JwtAuthenticationFilter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtAuthenticationFilter: JwtAuthenticationFilter, //필터 등록
    private val authenticationEntryPoint: CustomAuthenticationEntryPoint
) {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        return http
            .httpBasic { it.disable() } //HTTP Basic 인증사용 비활성화
            .formLogin { it.disable() } //로그인 인증사용 비활성화
            .csrf { it.disable() } //공격방지 기능 비활성화
            .authorizeHttpRequests { //HTTP요청에 대한 인가설정
                it.requestMatchers (
                    "/login",
                    "/signup",
                    "/swagger-ui/**",
                    "/v3/api-docs/**"

                    ).permitAll() //위 경로들은 모든 사용자에게 허용
                    .anyRequest().authenticated() //그외는 인증을 거친후 접근가능
                }
                    .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter::class.java)
            .exceptionHandling {
                it.authenticationEntryPoint(authenticationEntryPoint)
            }
                    .build()
            }
    }