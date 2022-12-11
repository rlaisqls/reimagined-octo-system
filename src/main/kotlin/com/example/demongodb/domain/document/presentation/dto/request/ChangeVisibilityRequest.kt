package com.example.demongodb.domain.document.presentation.dto.request

import com.example.demongodb.domain.document.domain.enums.Visibility

data class ChangeVisibilityRequest (
    val visibility: Visibility
)