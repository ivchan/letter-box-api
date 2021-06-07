package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.daos.DocumentRepository
import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.CustomError
import dev4c0ffee.letterboxapi.entities.Document
import dev4c0ffee.letterboxapi.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

@Service
class DocumentService : BaseService() {
    @Autowired
    lateinit var userRepo: UserRepository

    @Autowired
    lateinit var docRepo: DocumentRepository

    @Transactional
    fun addDocument(doc: Document): Document {
        if (doc.id.isEmpty()) {
            doc.id = UUID.randomUUID().toString()
        }
        return this.docRepo.save(doc)
    }

    fun listDocuments(): List<Document> {
        return this.docRepo.findAll()
    }

    @Transactional
    fun updateDocument(doc: Document): Document {
        if (doc.id.isEmpty()) throw CustomError("document id is not provided.")
        val docRecord = this.docRepo.findByIdOrNull(doc.id) ?: throw CustomError("document does not exists.")
        docRecord.issuer = doc.issuer
        docRecord.referenceNo = doc.referenceNo
        docRecord.status = doc.status
        docRecord.subject = doc.subject
        docRecord.updatedTime = LocalDateTime.now()
        return docRepo.save(docRecord)
    }

    @Transactional
    fun deleteDocument(id: String) {
        if (id.isEmpty()) throw CustomError("document id is not provided.")
        val docRecord = this.docRepo.findByIdOrNull(id) ?: throw CustomError("document does not exists.")
        docRepo.deleteById(id)
    }
}