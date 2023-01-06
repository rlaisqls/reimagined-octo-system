package com.example.demongodb.domain.document.domain.repository

import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.QDocument.document
import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import com.example.demongodb.domain.user.domain.User
import com.querydsl.core.types.dsl.BooleanExpression

fun DocumentRepository.findByWriter(user: User): List<Document> {
    return findAll(document.writer.id.eq(user.id)).toList()
}

fun DocumentRepository.findByVersionAndWriterInfo(
    version: Int,
    grade: Int?,
    classNum: Int?,
    jobTitle: JobTitle?
): List<Document> {

    return findAll(
        document.version.eq(version)
            .and(eqGrade(grade))
            .and(eqClassNum(classNum))
            .and(eqJobTitle(jobTitle))
    ).toList()
}

private fun eqGrade(grade: Int?): BooleanExpression? {
    return if (grade != null) document.writer.grade.eq(grade) else null
}

private fun eqClassNum(classNum: Int?): BooleanExpression? {
    return if (classNum != null) document.writer.classNum.eq(classNum) else null
}

private fun eqJobTitle(jobTitle: JobTitle?): BooleanExpression? {
    return if (jobTitle != null) document.writer.jobTitle.eq(jobTitle) else null
}