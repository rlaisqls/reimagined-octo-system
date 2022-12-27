package com.example.demongodb.domain.document.domain.repository


import com.example.demongodb.domain.document.domain.Document
import com.example.demongodb.domain.document.domain.QDocument.document
import com.example.demongodb.domain.document.domain.element.enums.JobTitle
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory

class CustomDocumentRepositoryImpl(
    private val queryFactory: JPAQueryFactory
): CustomDocumentRepository {

    override fun queryByVersionAndWriterInfo(
        version: Int,
        grade: Int?,
        classNum: Int?,
        jobTitle: JobTitle?
    ): List<Document> {

        return queryFactory
            .selectFrom(document)
            .where(
                document.version.eq(version),
                eqGrade(grade),
                eqClassNum(classNum),
                eqJobTitle(jobTitle)
            )
            .fetch()
    }

    private fun eqGrade(grade: Int?): BooleanExpression? {
        return if(grade!=null) document.writer.grade.eq(grade) else null
    }

    private fun eqClassNum(classNum: Int?): BooleanExpression? {
        return if(classNum!=null) document.writer.classNum.eq(classNum) else null
    }

    private fun eqJobTitle(jobTitle: JobTitle?): BooleanExpression? {
        return if(jobTitle!=null) document.writer.jobTitle.eq(jobTitle) else null
    }
}