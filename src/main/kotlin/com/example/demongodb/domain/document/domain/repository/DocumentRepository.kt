package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface DocumentRepository: MongoRepository<Document, UUID>, CustomDocumentRepository {

    fun queryById(documentId: UUID): Document?
    fun queryByWriter_Id(userId: UUID): List<Document>

}