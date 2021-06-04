package dev4c0ffee.letterboxapi.controllers

import dev4c0ffee.letterboxapi.entities.User
import dev4c0ffee.letterboxapi.services.AdminService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController : BaseController() {
    @Autowired
    lateinit var adminService: AdminService

    /*
    @GetMapping("/hello")
    fun helloWorld(): ResponseEntity<User?> {
        val user: User?
        user = User("", "", "", "", "", "")
        user.id = UUID.randomUUID().toString()
        user.userName = "Peter Chan"
        return ResponseEntity<User?>(user, HttpStatus.OK)
    }*/

    @GetMapping
    fun list() : ResponseEntity<List<User>> {
        val result = adminService.listUsers()
        return ResponseEntity.ok(result)
    }

    @GetMapping(value = ["/{id}"])
    fun get(@PathVariable id: String): ResponseEntity<User>{
        val result = adminService.getUser(id)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun add(@RequestBody user: User): ResponseEntity<User?> {
        val result = adminService.addUser(user)
        return ResponseEntity.ok(result)
    }

    @PutMapping
    fun update(@RequestBody user: User): ResponseEntity<User?> {
        val result = adminService.updateUser(user)
        return ResponseEntity.ok(result)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: String): ResponseEntity<String> {
        adminService.deleteUser(id)
        return ResponseEntity.ok("Success")
    }
}