package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import java.util.UUID
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.ReactiveQuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import java.awt.print.Book

@Repository
interface DocumentRepository: MongoRepository<Document, UUID>, CustomDocumentRepository {

    fun queryById(documentId: UUID): Document?
    fun queryByWriter_Id(userId: UUID): List<Document>

}