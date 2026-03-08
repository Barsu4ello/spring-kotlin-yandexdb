package ru.gorbunov.springkotlinyandexdb.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import ru.gorbunov.springkotlinyandexdb.domain.User
import ru.gorbunov.springkotlinyandexdb.dto.UserWithRoleInlineDto

interface UserRepo: JpaRepository<User, Int> {

    @Query("SELECT new ru.gorbunov.springkotlinyandexdb.dto.UserWithRoleInlineDto(u.id, u.name, r.id, r.name)" +
            " from User u" +
            " LEFT JOIN u.roles r " +
            " WHERE u.id=:userId")
    fun findUserWithRoleInlineDtoByUserId(userId: String): List<UserWithRoleInlineDto>
}