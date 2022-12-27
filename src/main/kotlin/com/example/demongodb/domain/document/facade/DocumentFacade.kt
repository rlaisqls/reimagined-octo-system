package com.example.demongodb.domain.document.facade

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class DocumentFacade(
    private val documentRepository: DocumentRepository
) {

    fun queryById(documentId: UUID): Document {
        return documentRepository.queryById(documentId)?: throw DocumentNotFoundException
    }

    fun queryByWriter(user: User): List<Document> {
        return documentRepository.queryByWriter_Id(user.id)
    }

}