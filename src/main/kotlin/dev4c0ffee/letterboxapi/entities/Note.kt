package dev4c0ffee.letterboxapi.entities

import org.springframework.boot.context.properties.bind.DefaultValue
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "NOTES")
class Note(
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

    @Column(length = 36, nullable = false)
    var thumbImageFile: String,

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    var isDeleted: Boolean,

    @Column(nullable = true)
    var deletedTime: LocalDateTime,
) : BaseEntity()