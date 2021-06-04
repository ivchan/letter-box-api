package dev4c0ffee.letterboxapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Index
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "USERS")
class User(
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var userName: String,

    @NotBlank
    @Size(max = 200)
    @Column(length = 200, nullable = false)
    var email: String,

    @NotBlank
    @Size(max = 10)
    @Column(length = 10)
    var status: String,

    @NotBlank
    @Size(max = 10)
    @Column(length = 10)
    var userRole: String,

    @NotBlank
    @Size(max = 20)
    @Column(unique = true, length = 20)
    var loginId: String,

    @Column(length = 50, nullable = false)
    var password: String
) : BaseEntity()