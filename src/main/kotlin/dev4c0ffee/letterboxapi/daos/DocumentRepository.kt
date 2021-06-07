package dev4c0ffee.letterboxapi.daos

import dev4c0ffee.letterboxapi.entities.Document
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DocumentRepository : JpaRepository<Document, String> {
}