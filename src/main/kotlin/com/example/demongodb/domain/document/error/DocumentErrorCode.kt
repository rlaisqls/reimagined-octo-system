package com.example.demongodb.domain.document.error

import com.example.demongodb.global.error.exception.ErrorProperty


enum class DocumentErrorCode (
    private val status: Int,
    private val message: String
) : ErrorProperty {

    INVALID_PROJECT(400, "Invalid Project Date"),
    DOCUMENT_ACCESS_RIGHT(403, "Do Not Have Access To The Document.\n"),
    DOCUMENT_NOT_FOUND(404, "Document Not Found");

    override fun status(): Int = status
    override fun message(): String = message

}