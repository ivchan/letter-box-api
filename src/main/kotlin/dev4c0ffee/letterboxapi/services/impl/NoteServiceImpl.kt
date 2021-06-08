package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.daos.NoteRepository
import dev4c0ffee.letterboxapi.daos.NotebookRepository
import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.CustomError
import dev4c0ffee.letterboxapi.entities.Note
import dev4c0ffee.letterboxapi.entities.Notebook
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

@Service
class NoteServiceImpl : BaseService(), NoteService{
    @Autowired
    lateinit var userRepo: UserRepository

    @Autowired
    lateinit var noteRepo: NoteRepository

    @Autowired
    lateinit var notebookRepo: NotebookRepository

    @Transactional
    override fun addNote(doc: Note): Note {
        if (doc.id.isEmpty()) {
            doc.id = UUID.randomUUID().toString()
        }
        doc.createdTime = LocalDateTime.now()
        return this.noteRepo.save(doc)
    }

    override fun listNotes(): List<Note> {
        return this.noteRepo.findAll()
    }

    override fun getNote(id: String): Note? {
        return this.noteRepo.findByIdOrNull(id)
    }

    @Transactional
    override fun updateNote(note: Note): Note {
        if (note.id.isEmpty()) throw CustomError("document id is not provided.")
        val noteRecord = this.noteRepo.findByIdOrNull(note.id) ?: throw CustomError("document does not exists.")
        noteRecord.issuer = note.issuer
        noteRecord.referenceNo = note.referenceNo
        noteRecord.status = note.status
        noteRecord.subject = note.subject
        noteRecord.updatedTime = LocalDateTime.now()
        return noteRepo.save(noteRecord)
    }

    @Transactional
    override fun deleteDocument(id: String) {
        if (id.isEmpty()) throw CustomError("document id is not provided.")
        if (this.noteRepo.findByIdOrNull(id) == null) throw CustomError("document does not exists.")
        noteRepo.deleteById(id)
    }


    @Transactional
    override fun addNotebook(notebook: Notebook): Notebook {
        if (notebook.id.isEmpty()) {
            notebook.id = UUID.randomUUID().toString()
        }
        notebook.createdTime = LocalDateTime.now()
        return this.notebookRepo.save(notebook)
    }

    override fun listNotebooks(): List<Notebook> {
        return this.notebookRepo.findAll()
    }

    override fun getNotebook(id: String): Notebook? {
        return this.notebookRepo.findByIdOrNull(id)
    }

    @Transactional
    override fun updateNotebook(notebook: Notebook): Notebook {
        if (notebook.id.isEmpty()) throw CustomError("notebook id is not provided.")
        val notebookRecord = this.notebookRepo.findByIdOrNull(notebook.id)
        if (notebookRecord == null) throw CustomError("notebook record not exists.")
        notebookRecord.title = notebook.title
        notebookRecord.updatedTime = LocalDateTime.now()
        return this.notebookRepo.save(notebook)
    }

    @Transactional
    override fun deleteNotebook(id: String) {
        if (id.isEmpty()) throw CustomError("notebook id is not provided.")
        val notebookRecord = this.notebookRepo.findByIdOrNull(id)
        if (notebookRecord == null) throw CustomError("notebook record not exists.")
        notebookRepo.delete(notebookRecord)
    }
}