package com.example.demongodb.domain.user.service

import com.example.demongodb.domain.student.domain.repository.StudentRepository
import com.example.demongodb.domain.user.facade.UserFacade
import com.example.demongodb.domain.user.presentation.dto.response.QueryUserInfoResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service


@Service
class QueryMyInfoService(
    private val userFacade: UserFacade,
    private val studentRepository: StudentRepository
) {
    @Transactional
    fun execute(): QueryUserInfoResponse {

        val user = userFacade.getCurrentUser()
        val student = studentRepository.findByUser(user)

        return user.run {
            QueryUserInfoResponse(
                userId = id,
                name = name,
                email = email,
                studentID = student?.studentID
            )
        }
    }

}