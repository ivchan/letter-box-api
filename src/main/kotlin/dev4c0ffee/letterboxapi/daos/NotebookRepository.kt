package dev4c0ffee.letterboxapi.daos

import dev4c0ffee.letterboxapi.entities.Note
import dev4c0ffee.letterboxapi.entities.Notebook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotebookRepository : JpaRepository<Notebook, String> {
}