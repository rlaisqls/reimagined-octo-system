package com.example.demongodb.domain.user.presentation.dto.request

import com.example.demongodb.global.util.RegexpUtil
import org.hibernate.validator.constraints.Length
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class SignUpRequest(

    @field:Length
    @field:NotBlank
    val name: String,

    @field:Email
    @field:NotBlank
    val email: String,

    @field:Pattern(regexp = RegexpUtil.PASSWORD_PATTERN)
    @field:NotBlank
    val password: String

)