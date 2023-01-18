package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DocumentRepository: MongoRepository<Document, UUID>, QuerydslPredicateExecutor<Document>