package com.example.demongodb.domain.document.service

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.element.WriterInfoElement
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.presentation.dto.request.CreateDocumentRequest
import com.example.demongodb.domain.student.facade.StudentFacade
import com.example.demongodb.domain.user.facade.UserFacade
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class CreateDocumentService(
    val userFacade: UserFacade,
    val documentRepository: DocumentRepository,
    val studentFacade: StudentFacade
) {
    @Transactional
    fun execute(request: CreateDocumentRequest) {

        val user = userFacade.getCurrentUser()
        val student = studentFacade.findByUser(user)

        documentRepository.save(
            Document(
                writer = WriterInfoElement(user, student, request.jobTitle),
                version = request.version,
            )
        )
    }

}