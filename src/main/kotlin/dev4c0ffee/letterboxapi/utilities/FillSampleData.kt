package dev4c0ffee.letterboxapi.utilities

import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.Notebook
import dev4c0ffee.letterboxapi.entities.User
import dev4c0ffee.letterboxapi.services.AdminService
import dev4c0ffee.letterboxapi.services.NoteService
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

    @Autowired
    lateinit var noteService: NoteService

    override fun onApplicationEvent(event: ApplicationReadyEvent) {
        val userAdmin = User(
            userName = "System Admin.",
            email = "29january@gmail.com",
            status = "active",
            userRole = "sysadmin",
            loginId = "admin",
            password = "")
        userAdmin.id = "ba5d48db-c97e-4084-9707-29ca6a368e0b"
        adminService.addUser(userAdmin)

        val userIvanChan = User(
            userName = "Ivan Chan",
            email = "29january@gmail.com",
            status = "active",
            userRole = "user",
            loginId = "ivan.chan",
            password = "")
        userIvanChan.id = "32440f50-c87f-47b9-986e-328824f54b6f"
        adminService.addUser(userIvanChan)

        val notebookHome = Notebook(
            title = "Home",
            notebookType = "folder",
            parentNotebook = null,
        )
        notebookHome.id = "88d440b9-883d-46af-bfe6-ff894e7101e3"
        noteService.addNotebook(notebookHome)

        val notebookSundry = Notebook(
            title = "Sundry",
            notebookType = "folder",
            parentNotebook = null,
        )
        notebookSundry.id = "cfbb12ee-c3b9-4a42-9b96-b60e345a2e3f"
        noteService.addNotebook(notebookSundry)

        val notebookWork = Notebook(
            title = "Work",
            notebookType = "folder",
            parentNotebook = null,
        )
        notebookWork.id = "9f83f879-3c4b-4b45-9259-17b62340ee8e"
        noteService.addNotebook(notebookWork)
    }
}