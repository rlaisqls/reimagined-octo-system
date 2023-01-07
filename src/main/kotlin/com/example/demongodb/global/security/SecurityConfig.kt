package com.example.demongodb.global.security

import com.example.demongodb.domain.user.domain.enums.Authority.STUDENT
import com.example.demongodb.global.security.jwt.JwtTokenProvider
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
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

            .requestMatchers(HttpMethod.POST, "/documents").hasAnyAuthority(STUDENT.toString())
            .requestMatchers(HttpMethod.GET, "/documents/my").hasAnyAuthority(STUDENT.toString())
            .requestMatchers(HttpMethod.GET, "/documents").authenticated()
            .requestMatchers(HttpMethod.GET, "/documents/{document-id}").authenticated()
            .requestMatchers(HttpMethod.PATCH, "/documents/visibility").hasAnyAuthority(STUDENT.toString())
            .requestMatchers(HttpMethod.PATCH, "/documents/introduce").hasAnyAuthority(STUDENT.toString())
            .requestMatchers(HttpMethod.PATCH, "/documents/experience").hasAnyAuthority(STUDENT.toString())
            .requestMatchers(HttpMethod.PATCH, "/documents/project").hasAnyAuthority(STUDENT.toString())

        http.apply(FilterConfig(jwtTokenProvider, objectMapper))

        return http.build()
    }

}