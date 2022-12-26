package com.example.demongodb.domain.document.presentation.dto.request

import org.jetbrains.annotations.NotNull
import java.util.UUID

data class QueryDocumentInfoRequest(

    @field:NotNull
    val documentId: UUID

)