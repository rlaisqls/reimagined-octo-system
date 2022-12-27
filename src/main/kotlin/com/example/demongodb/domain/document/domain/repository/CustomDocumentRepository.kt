package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.element.enums.JobTitle

interface CustomDocumentRepository {

    fun queryByVersionAndWriterInfo(
        version: Int,
        grade: Int?,
        classNum: Int?,
        jobTitle: JobTitle?
    ): List<Document>

}