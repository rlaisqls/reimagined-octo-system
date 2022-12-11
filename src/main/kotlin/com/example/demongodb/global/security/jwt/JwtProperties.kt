package com.example.demongodb.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import org.springframework.context.annotation.Configuration
import java.util.*

//@ConstructorBinding
@Configuration
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    val secretKey: String = Base64.getEncoder().encodeToString("c2lsdmVybmluZS10ZWNoLXNwcmluZy1ib290LWp3dC10dXRvcmlhbC1zZWNyZXQtc2lsdmVybmluZS10ZWNoLXNwcmluZy1ib290LWp3dC10dXRvcmlhbC1zZWNyZXQK".toByteArray()),
    val accessExp: Long = 180000,
    val refreshExp: Long = 180 //TODO DLRJ
)