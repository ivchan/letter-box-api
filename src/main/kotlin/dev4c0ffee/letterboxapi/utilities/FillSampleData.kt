package dev4c0ffee.letterboxapi.utilities

import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.User
import dev4c0ffee.letterboxapi.services.AdminService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class FillSampleData : ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    lateinit var adminService: AdminService

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val userAdmin = User(
            userName = "System Admin.",
            email = "29january@gmail.com",
            status = "active",
            userRole = "sysadmin",
            loginId = "admin",
            password = "")
        userAdmin.id = "ba5d48db-c97e-4084-9707-29ca6a368e0b"
        userAdmin.createdTime = LocalDateTime.now()
        adminService.addUser(userAdmin)

        val userIvanChan = User(
            userName = "Ivan Chan",
            email = "29january@gmail.com",
            status = "active",
            userRole = "user",
            loginId = "ivan.chan",
            password = "")
        userIvanChan.id = "32440f50-c87f-47b9-986e-328824f54b6f"
        userIvanChan.createdTime = LocalDateTime.now()
        adminService.addUser(userIvanChan)
    }
}