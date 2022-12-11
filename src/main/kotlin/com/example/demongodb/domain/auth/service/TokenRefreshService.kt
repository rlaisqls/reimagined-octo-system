package com.example.demongodb.domain.auth.service

import com.example.demongodb.domain.auth.domain.RefreshToken
import com.example.demongodb.domain.auth.domain.error.RefreshTokenNotFoundException
import com.example.demongodb.domain.auth.domain.repository.RefreshTokenRepository
import com.example.demongodb.domain.auth.presentation.dto.response.TokenResponse
import com.example.demongodb.global.security.jwt.JwtProperties
import com.example.demongodb.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service

@Service
class TokenRefreshService(
    private val jwtTokenProvider: JwtTokenProvider,
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository
) {

    fun execute(refreshToken: String): TokenResponse {

        val redisRefreshToken: RefreshToken = refreshTokenRepository.findByToken(refreshToken)
            ?: throw RefreshTokenNotFoundException

        val email = redisRefreshToken.email
        val authority = redisRefreshToken.authority

        val tokens = jwtTokenProvider.generateTokens(email, authority)

        redisRefreshToken.updateToken(tokens.refreshToken, jwtProperties.refreshExp)

        return tokens
    }
}
