package dev4c0ffee.letterboxapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "ATTACHMENTS")
class Attachment(
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var location: String,

    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var fileName: String,

    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var physicalFileName: String,

    @Size(max = 20)
    @Column(length = 20, nullable = false)
    var fileExtension: String,
) : BaseEntity()