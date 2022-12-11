package com.example.demongodb.domain.user.presentation.dto.request


import com.example.demongodb.global.util.RegexpUtil
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Pattern

data class ChangePasswordRequest(

    @field:NotBlank
    val oldPassword: String,

    @field:NotBlank
    @field:Pattern(regexp = RegexpUtil.PASSWORD_PATTERN)
    val newPassword: String
)