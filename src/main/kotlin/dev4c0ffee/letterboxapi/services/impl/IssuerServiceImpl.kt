package dev4c0ffee.letterboxapi.services

import dev4c0ffee.letterboxapi.daos.IssuerRepository
import dev4c0ffee.letterboxapi.daos.UserRepository
import dev4c0ffee.letterboxapi.entities.CustomError
import dev4c0ffee.letterboxapi.entities.Issuer
import dev4c0ffee.letterboxapi.entities.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import javax.transaction.Transactional

@Service
class IssuerServiceImpl : BaseService(), IssuerService {
    @Autowired
    lateinit var issuerRepo: IssuerRepository


    @Transactional
    override fun addIssuer(issuer: Issuer): Issuer {
        if (issuer.id.isEmpty()) {
            issuer.id = UUID.randomUUID().toString()
        }
        issuer.createdTime = LocalDateTime.now()
        return this.issuerRepo.save(issuer)
    }

    override fun listIssuers(): List<Issuer> {
        return this.issuerRepo.findAll()
    }

    override fun getIssuer(id: String): Issuer {
        return this.issuerRepo.getById(id)
    }

    @Transactional
    override fun updateIssuer(issuer: Issuer): Issuer {
        if (issuer.id.isEmpty()) throw CustomError("issuer id is not provided.")
        val issuerRecord = this.issuerRepo.findByIdOrNull(issuer.id) ?: throw CustomError("issuer does not exists.")
        issuerRecord.name = issuer.name
        issuerRecord.updatedTime = LocalDateTime.now()
        return issuerRepo.save(issuerRecord)
    }

    @Transactional
    override fun deleteIssuer(id: String) {
        if (id.isEmpty()) throw CustomError("issuer id is not provided.")
        if (this.issuerRepo.findByIdOrNull(id) == null) throw CustomError("document does not exists.")
        issuerRepo.deleteById(id)
    }
}