package com.teamsparta.springtodo.exception

data class ModelNotfoundException(val modelName: String, val id: Long?) : RuntimeException(
    "Model $modelName not found with given id: $id"
)