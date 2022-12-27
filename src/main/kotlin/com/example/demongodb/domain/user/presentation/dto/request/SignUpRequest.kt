package com.example.demongodb.domain.user.presentation.dto.request

import com.example.demongodb.global.util.RegexpUtil
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Pattern
import org.hibernate.validator.constraints.Length
import org.hibernate.validator.constraints.Range

data class SignUpRequest(

    @field:Length(max = 15)
    @field:NotBlank
    val name: String,

    @field:Length(max = 60)
    @field:Email
    @field:NotBlank
    val email: String,

    @field:Pattern(regexp = RegexpUtil.PASSWORD_PATTERN)
    @field:NotBlank
    val password: String,

    @field:Range(min=1101, max=3320)
    @field:NotNull
    val studentID: Int

)