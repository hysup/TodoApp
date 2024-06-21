package com.teamsparta.springtodo.todo.entity

import com.fasterxml.jackson.annotation.JsonCreator
import org.apache.commons.lang3.EnumUtils

enum class TodoStatus {
    OPEN,
    CLOSED;

    companion object {
        @JvmStatic
        @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
        fun parse(name: String?): TodoStatus? =
            name?.let { EnumUtils.getEnumIgnoreCase(TodoStatus::class.java, it.trim()) }
    }
}