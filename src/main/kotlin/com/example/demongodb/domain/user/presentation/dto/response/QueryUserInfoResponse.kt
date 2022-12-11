package com.example.demongodb.domain.user.presentation.dto.response

data class QueryUserInfoResponse(
    val userId: Long,
    val name: String,
    val email: String
)