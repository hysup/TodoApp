package com.teamsparta.springtodo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.EnableAspectJAutoProxy

@EnableAspectJAutoProxy
@SpringBootApplication
class SpringtodoApplication

fun main(args: Array<String>) {
	runApplication<SpringtodoApplication>(*args)
}
