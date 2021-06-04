package dev4c0ffee.letterboxapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "DOCUMENTS")
class Document(
    @NotBlank
    @Column(length = 36, nullable = false)
    var issuer: String,

    @NotBlank
    @Column(length = 200, nullable = false)
    var subject: String,

    @NotBlank
    @Column(length = 100, nullable = false)
    var referenceNo: String,

    @NotBlank
    @Column(length = 10, nullable = false)
    var status: String,
) : BaseEntity()