package com.teamsparta.springtodo.config.aop

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.stereotype.Component


//@Aspect
//@Component
class Testaop {

    @Around("execution(* com.teamsparta.springtodo.todo.service.TodoService.getTodoById(..))")
    fun thisIsAdvice(joinPoint: ProceedingJoinPoint) {
        println("AOP START !!")
        joinPoint.proceed()
        println("AOP END !!")

    }
}