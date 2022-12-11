package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface DocumentsRepository: MongoRepository<Document, ObjectId> {
}