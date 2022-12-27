package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.element.enums.JobTitle

data class CreateDocumentRequest (
    val version: Int,
    val jobTitle: JobTitle
)