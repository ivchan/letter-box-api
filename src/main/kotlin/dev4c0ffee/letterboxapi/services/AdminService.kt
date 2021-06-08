package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.CustomError
import dev4c0ffee.letterboxapi.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

interface AdminService{
    fun listUsers(): List<User>
    fun getUser(id: String) : User?
    fun addUser(user: User): User
    fun updateUser(user: User): User
    fun deleteUser(id: String)
}