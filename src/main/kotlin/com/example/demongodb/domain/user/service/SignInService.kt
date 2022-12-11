package com.example.demongodb.domain.user.service


import com.example.demongodb.domain.auth.presentation.dto.response.TokenResponse
import com.example.demongodb.domain.user.facade.UserFacade
import com.example.demongodb.domain.user.presentation.dto.request.SignInRequest
import com.example.demongodb.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import jakarta.transaction.Transactional

@Service
class SignInService(
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(request: SignInRequest): TokenResponse {

        val email = request.email
        val password = request.password

        val user = userFacade.findByEmail(email)

        userFacade.checkPassword(user, password)

        return jwtTokenProvider.generateTokens(email, user.authority)
    }
}