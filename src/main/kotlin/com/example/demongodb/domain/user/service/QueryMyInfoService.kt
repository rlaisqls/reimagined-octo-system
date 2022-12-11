package com.example.demongodb.domain.user.service

import com.example.demongodb.domain.user.facade.UserFacade
import com.example.demongodb.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.stereotype.Service


@Service
class QueryMyInfoService(
    private val userFacade: UserFacade
) {
    fun execute(): QueryUserInfoResponse {

        val user = userFacade.getCurrentUser()

        val a = if(true) null else "dd"

        return user.run {
            QueryUserInfoResponse(
                userId = id,
                name = name,
                email = email
            )
        }
    }
}