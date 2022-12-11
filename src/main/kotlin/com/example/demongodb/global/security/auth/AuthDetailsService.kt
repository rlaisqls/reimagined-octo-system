package com.example.demongodb.global.security.auth

import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.domain.user.domain.repository.UserRepository
import com.example.demongodb.domain.user.error.UserNotFoundException
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userRepository: UserRepository
): UserDetailsService {

    override fun loadUserByUsername(email: String): UserDetails {
        val user: User = userRepository.findByEmail(email) ?: throw UserNotFoundException
        return AuthDetails(user)
    }

}