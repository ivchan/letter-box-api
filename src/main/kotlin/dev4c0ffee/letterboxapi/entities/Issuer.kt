package dev4c0ffee.letterboxapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "ISSUERS")
class Issuer(
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var name: String
) : BaseEntity()