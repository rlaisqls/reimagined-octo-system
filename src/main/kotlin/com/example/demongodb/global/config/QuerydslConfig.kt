package com.example.demongodb.global.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.repository.support.MongoRepositoryFactory
import org.springframework.data.repository.core.support.RepositoryFactorySupport


@Configuration
class QuerydslConfig(
    @PersistenceContext
    private val entityManager: EntityManager
) {

    @Bean
    fun JPAQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }

    @Bean
    fun mongoRepositoryFactory(operations: MongoOperations): MongoRepositoryFactory {
        return MongoRepositoryFactory(operations)
    }
}