package com.example.demongodb.domain.company.presentation.dto.request

data class RequestCreateRequest (
    val companyName: String,
    val description: String,
    val logoImage: String,
    val phoneNumber: String
)