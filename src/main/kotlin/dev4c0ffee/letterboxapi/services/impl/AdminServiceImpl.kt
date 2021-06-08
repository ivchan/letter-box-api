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

@Service
class AdminServiceImpl : BaseService(), AdminService {
    @Autowired
    lateinit var userRepo: UserRepository

    @Transactional
    override fun addUser(user: User): User {
        if (user.id.isEmpty()) {
            user.id = UUID.randomUUID().toString()
        }
        user.createdTime = LocalDateTime.now()
        return this.userRepo.save(user)
    }

    override fun listUsers(): List<User> {
        return this.userRepo.findAll()
    }

    @Transactional
    override fun updateUser(user: User): User {
        if (user.id.isEmpty()) throw CustomError("Invalid ID")
        val u = userRepo.findByIdOrNull(user.id) ?: throw CustomError("user does not exists.")
        u.userName = user.userName
        u.email = user.email
        u.status = user.status
        u.userRole = user.userRole
        u.loginId = user.loginId
        u.updatedTime = LocalDateTime.now()
        return this.userRepo.save(u)
    }

    @Transactional
    override fun deleteUser(id: String) {
        this.userRepo.deleteById(id)
    }

    override fun getUser(id: String) : User? {
        return this.userRepo.findByIdOrNull(id)
    }
}