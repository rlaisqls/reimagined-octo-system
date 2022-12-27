package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.enums.Visibility
import java.util.UUID

data class ChangeVisibilityRequest (
    val documentId: UUID,
    val visibility: Visibility
)