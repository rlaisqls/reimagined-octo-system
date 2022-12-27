package com.example.demongodb.domain.document.domain.element

import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import com.example.demongodb.domain.student.domain.Student
import com.example.demongodb.domain.user.domain.User
import com.querydsl.core.annotations.QueryEmbeddable
import com.querydsl.core.annotations.QueryEntity
import java.util.UUID

class WriterInfoElement (

    val id: UUID,
    val name: String,
    val email: String,

    val grade: Int,
    val classNum: Int,
    val number: Int,

    val jobTitle: JobTitle

) {
    constructor(user: User, student: Student, jobTitle: JobTitle) : this(

        id = user.id,
        name = user.name,
        email = user.email,

        grade = student.grade,
        classNum = student.classNum,
        number = student.number,

        jobTitle = jobTitle

    )
}