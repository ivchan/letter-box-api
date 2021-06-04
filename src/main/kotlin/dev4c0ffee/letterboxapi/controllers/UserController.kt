package dev4c0ffee.letterboxapi.controllers

import dev4c0ffee.letterboxapi.entities.User
import dev4c0ffee.letterboxapi.daos.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController {
    @Autowired
    lateinit var userRepo: UserRepository

    @GetMapping("/hello")
    fun helloWorld(): ResponseEntity<User?> {
        val user: User?
        user = User("", "", "", "", "", "")
        user.id = UUID.randomUUID().toString()
        user.userName = "Peter Chan"
        return ResponseEntity<User?>(user, HttpStatus.OK)
    }

    @GetMapping("/add")
    fun add(): ResponseEntity<User?> {
        val user: User?
        user = User("", "", "", "", "", "")
        user.id = UUID.randomUUID().toString()
        user.userName = "Cheung Sin Man"
        user.email = "cheungsinman@gmail.com"
        user.loginId = "cheung"
        val result = userRepo.save(user)
        return ResponseEntity<User?>(result, HttpStatus.OK)
    }
}