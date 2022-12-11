package com.example.demongodb.domain.user.service

import com.example.demongodb.domain.user.facade.UserFacade
import com.example.demongodb.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service

@Service
class QueryUserInfoService(
    private val userFacade: UserFacade
) {
    fun execute(userId: Long): QueryUserInfoResponse {

        val user = userFacade.findById(userId)
        return user.run {
            QueryUserInfoResponse(
                userId = id,
                email = email,
                name = name
            )
        }
    }
}