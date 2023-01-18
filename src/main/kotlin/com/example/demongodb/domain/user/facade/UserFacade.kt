package com.example.demongodb.domain.user.facade

import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.domain.user.domain.repository.UserRepository
import com.example.demongodb.domain.user.error.PasswordMismatchException
import com.example.demongodb.domain.user.error.UserAlreadyExistException
import com.example.demongodb.domain.user.error.UserNotFoundException
import com.example.demongodb.global.security.auth.AuthDetails
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Component
import java.util.*


@Component
class UserFacade(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {

    fun getCurrentUser(): User {
        val authDetail = SecurityContextHolder.getContext().authentication.principal as AuthDetails
        return authDetail.user
    }

    fun findById(userId: UUID): User {
        return userRepository.findById(userId)
            .orElseThrow { UserNotFoundException }
    }

    fun findByEmail(email: String) : User {
        return userRepository.findByEmail(email) ?: throw UserNotFoundException
    }

    fun checkEmailExist(email: String) {
        println("UserFacade.checkEmailExist")
        println(email)
        println(userRepository.findByEmail(email))
        userRepository.findByEmail(email)?.let { throw UserAlreadyExistException }
    }

    fun checkPassword(user:User, password: String) {
        if (!passwordEncoder.matches(password, user.password)){
            throw PasswordMismatchException
        }
    }

}