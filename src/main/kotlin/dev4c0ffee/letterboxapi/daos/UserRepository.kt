package dev4c0ffee.letterboxapi.daos

import dev4c0ffee.letterboxapi.entities.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String> {
}