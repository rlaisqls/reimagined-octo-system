package com.example.demongodb.domain.document.domain.repository

/*
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

        /*
        return queryFactory
            .selectFrom(document)
            .where(
                document.version.eq(version)
            )
            .fetch()
        */
        return listOf()
    }

}*/