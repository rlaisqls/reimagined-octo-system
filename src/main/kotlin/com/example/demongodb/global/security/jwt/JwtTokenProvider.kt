package com.example.demongodb.global.security.jwt

import com.example.demongodb.domain.auth.domain.RefreshToken
import com.example.demongodb.domain.auth.domain.repository.RefreshTokenRepository
import com.example.demongodb.domain.auth.presentation.dto.response.TokenResponse
import com.example.demongodb.domain.user.domain.enums.Authority
import com.example.demongodb.global.security.auth.AuthDetailsService
import com.example.demongodb.global.security.exception.ExpiredTokenException
import com.example.demongodb.global.security.exception.InvalidTokenException
import io.jsonwebtoken.*
import io.jsonwebtoken.security.Keys
import jakarta.servlet.http.HttpServletRequest
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.util.*


@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val authDetailsService: AuthDetailsService
) {

    fun generateTokens(email: String, authority: Authority): TokenResponse {
        return TokenResponse(
            accessToken = createAccessToken(email, authority),
            accessTokenExp = LocalDateTime.now().plusSeconds(jwtProperties.accessExp),
            refreshToken = createRefreshToken(email, authority)
        )
    }

    fun createAccessToken(email: String, authority: Authority): String {
        return createToken(email, authority, JwtProperty.ACCESS, jwtProperties.accessExp)
    }

    fun createRefreshToken(email: String, authority: Authority): String {
        val token = createToken(email, authority, JwtProperty.REFRESH, jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(
                email = email,
                token = token,
                authority = authority,
                expiration = jwtProperties.refreshExp * 1000
            )
        )
        return token
    }

    private fun createToken(email: String, authority: Authority, jwtType: String, exp: Long): String {
        return Jwts.builder()
            .signWith(Keys.hmacShaKeyFor(jwtProperties.secretKey.toByteArray()), SignatureAlgorithm.HS256)
            .setHeaderParam(Header.JWT_TYPE, jwtType)
            .setId(email)
            .claim(JwtProperty.AUTHORITY, authority)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    fun getAuthentication(token: String): Authentication {

        val claims = getClaims(token)
        if (claims.header[Header.JWT_TYPE] != JwtProperty.ACCESS) {
            throw InvalidTokenException
        }

        val details = authDetailsService.loadUserByUsername(claims.body.id)

        return UsernamePasswordAuthenticationToken(details, "", details.authorities)
    }

    private fun getClaims(token: String): Jws<Claims> {
        return try {
            Jwts.parserBuilder()
                .setSigningKey(jwtProperties.secretKey.toByteArray())
                .build()
                .parseClaimsJws(token)
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw ExpiredTokenException
                else -> throw InvalidTokenException
            }
        }
    }

    fun resolveToken(request: HttpServletRequest): String? {

        val bearerToken = request.getHeader(JwtProperty.HEADER)

        if (bearerToken != null && (bearerToken.startsWith(JwtProperty.PREFIX))) {
            return bearerToken.substring(JwtProperty.PREFIX.length)
        }
        return null
    }

}