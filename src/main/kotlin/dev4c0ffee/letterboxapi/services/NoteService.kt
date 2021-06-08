package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.entities.Note
import dev4c0ffee.letterboxapi.entities.Notebook

interface NoteService{
    fun listNotes(): List<Note>

    fun getNote(id: String): Note?

    fun addNote(doc: Note): Note

    fun updateNote(note: Note): Note

    fun deleteDocument(id: String)

    fun listNotebooks(): List<Notebook>

    fun getNotebook(id: String): Notebook?

    fun addNotebook(notebook: Notebook): Notebook

    fun updateNotebook(notebook: Notebook): Notebook

    fun deleteNotebook(id: String)
}