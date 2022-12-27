package com.example.demongodb.domain.user.presentation.dto.response

import java.util.*

data class QueryUserInfoResponse(
    val userId: UUID,
    val name: String,
    val email: String,
    val studentID: Int?
)