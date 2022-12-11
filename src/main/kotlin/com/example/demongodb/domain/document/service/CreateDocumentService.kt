package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.element.UserInfoElement
import com.example.demongodb.domain.document.domain.enums.Visibility
import com.example.demongodb.domain.document.domain.repository.DocumentsRepository
import com.example.demongodb.domain.document.presentation.dto.request.CreateDocumentRequest
import com.example.demongodb.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class CreateDocumentService(
    val userFacade: UserFacade,
    val documentsRepository: DocumentsRepository
) {
    fun execute(request: CreateDocumentRequest) {

        val user = userFacade.getCurrentUser()

        documentsRepository.save(
            Document(
                version = request.version,
                grade = 1,
                visibility = Visibility.PRIVATE,
                updatedAt = LocalDateTime.now(),
                user = UserInfoElement(
                    name = user.name,
                    email = user.email
                ),
            )
        )

    }

}