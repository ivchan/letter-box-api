package dev4c0ffee.letterboxapi.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Entity
@Table(name = "NOTEBOOKS")
class Notebook(
    @NotBlank
    @Size(max = 100)
    @Column(length = 100, nullable = false)
    var title: String,

    @NotBlank
    @Size(max = 20)
    @Column(length = 20, nullable = false)
    var notebookType: String,

    @NotBlank
    @Size(max = 36)
    @Column(length = 36, nullable = true)
    var parentNotebook: String?,
) : BaseEntity()