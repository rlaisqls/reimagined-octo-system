package com.example.demongodb.domain.user.presentation.dto.request

import org.hibernate.validator.constraints.Length
import jakarta.validation.constraints.NotBlank

data class SignInRequest (

    @field:Length(min = 1, max = 40)
    @field:NotBlank
    val email: String,

    @field:Length(min = 1, max = 30)
    @field:NotBlank
    val password: String
)