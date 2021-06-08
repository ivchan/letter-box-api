package dev4c0ffee.letterboxapi.entities

import java.time.LocalDateTime
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Null
import javax.validation.constraints.Size

@MappedSuperclass
abstract class BaseEntity {
    @Size(max = 36)
    @NotNull
    @Id
    var id: String = ""

    var createdTime: LocalDateTime? = null

    var updatedTime: LocalDateTime? = null

}