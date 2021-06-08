package dev4c0ffee.letterboxapi.controllers

import dev4c0ffee.letterboxapi.entities.Notebook
import dev4c0ffee.letterboxapi.entities.User
import dev4c0ffee.letterboxapi.services.AdminService
import dev4c0ffee.letterboxapi.services.NoteService
import org.apache.coyote.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/notebook")
class NotebookController : BaseController() {
    @Autowired
    lateinit var adminService: AdminService

    @Autowired
    lateinit var noteService: NoteService

    @GetMapping
    fun list() : ResponseEntity<List<Notebook>> {
        val result = noteService.listNotebooks()
        return ResponseEntity.ok(result)
    }

    @GetMapping(value = ["/{id}"])
    fun get(@PathVariable id: String): ResponseEntity<Notebook>{
        val result = noteService.getNotebook(id)
        return ResponseEntity.ok(result)
    }

    @PostMapping
    fun add(@RequestBody notebook: Notebook): ResponseEntity<Notebook?> {
        val result = noteService.addNotebook(notebook)
        return ResponseEntity.ok(result)
    }

    @PutMapping
    fun update(@RequestBody notebook: Notebook): ResponseEntity<Notebook?> {
        val result = noteService.updateNotebook(notebook)
        return ResponseEntity.ok(result)
    }

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable id: String): ResponseEntity<String> {
        noteService.deleteNotebook(id)
        return ResponseEntity.ok("Success")
    }
}