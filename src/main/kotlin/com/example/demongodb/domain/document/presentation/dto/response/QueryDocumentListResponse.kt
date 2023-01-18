package com.example.demongodb.domain.document.presentation.dto.response

import com.example.demongodb.domain.document.domain.Document
import java.util.*

data class QueryDocumentListResponse (
    val list: List<DocumentResponse>
) {
    class DocumentResponse(
        val id: UUID,
        val writer: WriterInfoResponse,
        val version: Int
    ) {
        constructor(document: Document): this(
            id = document.id,
            writer = WriterInfoResponse(document.writer),
            version = document.version
        )
    }
}