package com.example.demongodb.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.example.demongodb.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
@Configuration
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper
) {

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.cors().and()
            .csrf().disable()
            .formLogin().disable()

        http.sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

        http.authorizeHttpRequests()
            .requestMatchers(HttpMethod.POST, "/users").permitAll()
            .requestMatchers(HttpMethod.POST, "/users/auth").permitAll()
            .requestMatchers(HttpMethod.PUT, "/users/auth").permitAll()
            .requestMatchers(HttpMethod.GET, "/users").authenticated()
            .requestMatchers(HttpMethod.GET, "/users/{user-id}").authenticated()

        http.apply(FilterConfig(jwtTokenProvider, objectMapper))

        return http.build()
    }

}