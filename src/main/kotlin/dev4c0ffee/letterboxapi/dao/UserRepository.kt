package dev4c0ffee.letterboxapi.dao

import dev4c0ffee.letterboxapi.entities.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, String> {
}