package com.example.demongodb.domain.document.presentation.dto.response

import com.example.demongodb.domain.document.domain.element.WriterInfoElement
import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import com.example.demongodb.domain.student.domain.Student
import java.util.*

data class WriterInfoResponse(
    val id: UUID,
    val name: String,
    val email: String,
    val studentID: Int,
    val jobTitle: JobTitle
) {
    constructor(writer: WriterInfoElement): this(
        id = writer.id,
        name = writer.name,
        email = writer.email,
        studentID = Student.toStudentID(writer.grade, writer.classNum, writer.number),
        jobTitle = writer.jobTitle
    )
}