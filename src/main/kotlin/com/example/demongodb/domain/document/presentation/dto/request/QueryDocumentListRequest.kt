package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import org.jetbrains.annotations.NotNull

data class QueryDocumentListRequest (

    @field:NotNull
    val version: Int,

    val jobTitle: JobTitle?,

    val classNum: Int?,

    val grade: Int?

)