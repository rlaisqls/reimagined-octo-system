package com.example.demongodb.domain.user.service

import com.example.demongodb.domain.auth.presentation.dto.response.TokenResponse
import com.example.demongodb.domain.student.domain.Student
import com.example.demongodb.domain.student.domain.repository.StudentRepository
import com.example.demongodb.domain.user.domain.User
import com.example.demongodb.domain.user.domain.enums.Authority
import com.example.demongodb.domain.user.domain.repository.UserRepository
import com.example.demongodb.domain.user.facade.UserFacade
import com.example.demongodb.domain.user.presentation.dto.request.SignUpRequest
import com.example.demongodb.global.security.jwt.JwtTokenProvider
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class SignUpService(
    private val passwordEncoder: PasswordEncoder,
    private val userRepository: UserRepository,
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
    private val studentRepository: StudentRepository
) {
    @Transactional
    fun execute(request: SignUpRequest): TokenResponse {

        userFacade.checkEmailExist(request.name)

        val user = userRepository.save(
            User(
                name = request.name,
                password = passwordEncoder.encode(request.password),
                email = request.email,
                authority = Authority.STUDENT
            )
        )

        studentRepository.save(
            Student(
                user = user,
                studentID = request.studentID
            )
        )

        return jwtTokenProvider.generateTokens(user.email, user.authority)
    }
}