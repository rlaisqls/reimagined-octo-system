package com.example.demongodb.domain.document.facade

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.repository.DocumentRepository
import com.example.demongodb.domain.document.domain.repository.findByWriter
import com.example.demongodb.domain.document.error.DocumentNotFoundException
import com.example.demongodb.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class DocumentFacade(
    private val documentRepository: DocumentRepository
) {

    fun findById(documentId: UUID): Document {
        return documentRepository.findById(documentId).orElseThrow{DocumentNotFoundException}
    }

    fun findByWriter(user: User): List<Document> {
        return documentRepository.findByWriter(user)
    }

}