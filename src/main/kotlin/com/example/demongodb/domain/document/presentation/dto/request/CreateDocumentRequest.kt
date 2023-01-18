package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.Range

data class CreateDocumentRequest (

    @field:NotNull
    @field:Range(min = 2022)
    val version: Int,

    @field:NotNull
    val jobTitle: JobTitle
)