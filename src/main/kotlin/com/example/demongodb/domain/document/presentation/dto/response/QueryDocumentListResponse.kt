package com.example.demongodb.domain.document.presentation.dto.response

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.element.WriterInfoElement
import com.example.demongodb.domain.student.domain.Student

data class QueryDocumentListResponse (
    val list: List<DocumentResponse>
) {
    companion object {
        data class DocumentResponse(
            val writer: WriterInfoElement,
            val version: Int
        ) {
            constructor(document: Document): this(
                writer = document.writer,
                version = document.version
            )
        }
    }
}