package ru.gorbunov.springkotlinyandexdb.controller

import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.gorbunov.springkotlinyandexdb.domain.User
import ru.gorbunov.springkotlinyandexdb.dto.UserWithRoleInlineDto
import ru.gorbunov.springkotlinyandexdb.repo.UserRepo

@RestController
@RequestMapping("/users")
class UserController(private val userRepo: UserRepo) {

    @GetMapping
    fun getUsers(): List<User> = userRepo.findAll()

    @GetMapping("dto-list")
    fun getUsersDto(@RequestParam("userId") userId: String): List<UserWithRoleInlineDto> =
        userRepo.findUserWithRoleInlineDtoByUserId(userId)

    @PostMapping
    fun saveUser(@RequestBody user: User): User = userRepo.save(user)

    @Transactional
    @PostMapping("/double-save")
    fun doubleSave(@RequestBody user: User): List<User> {
        val user1 = userRepo.saveAndFlush(user)
        throw RuntimeException()
        val userDouble = user.copy(user)
        val user2 = userRepo.saveAndFlush(userDouble)

        return listOf(user1, user2)
    }

    @PostMapping("/batch")
    fun saveUser(@RequestBody users: List<User>): List<User> = userRepo.saveAll(users)

}