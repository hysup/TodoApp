package com.teamsparta.springtodo.domain.Todo.controller



import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.teamsparta.springtodo.config.security.jwt.JwtPlugin
import com.teamsparta.springtodo.todo.dto.TodoResponse
import com.teamsparta.springtodo.todo.service.TodoService
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.extensions.spring.SpringExtension
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.junit5.MockKExtension
import io.mockk.mockk
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get


import java.time.ZonedDateTime



@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(MockKExtension::class)
class TodoControllerTest @Autowired constructor(
    private val mockMvc: MockMvc,
    private val jwtPlugin: JwtPlugin
): DescribeSpec({
    extensions(SpringExtension)

    afterContainer {
        clearAllMocks()
    }


    val todoService = mockk<TodoService>()

    describe("GET /{todoId}"){
        context("존재하는 ID를 요청할 때"){
            it("200 status code를 응답."){
                val todoId = 2L

                every { todoService.getTodoById(any()) } returns TodoResponse(
                    id = todoId,
                    title = "test_title",
                    content = "test",
                    author = "test_author",
                    createdAt = ZonedDateTime.now(),
                    isComplete = true
                )
                val jwtToken = jwtPlugin.generateAccessToken(
                    subject = "1",
                    email = "test@test.com"
                )
                val result = mockMvc.perform(
                    get("/api/v1/todos/$todoId")
                        .header("Authorization", "Bearer $jwtToken")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                ).andReturn()

                result.response.status shouldBe 200

                val responseDto = jacksonObjectMapper().readValue(
                    result.response.contentAsString,
                    TodoResponse::class.java
                )

                responseDto.id shouldBe todoId
        }
    }
}

})