package ru.gorbunov.springkotlinyandexdb.dto

data class UserWithRoleInlineDto(
    val id: String,
    val userName: String,
    val roleId: Int,
    val roleName: String,
)