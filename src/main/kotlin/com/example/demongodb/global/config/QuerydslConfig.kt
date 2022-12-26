package com.example.demongodb.global.config

import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class QuerydslConfig(
    @PersistenceContext
    private val entityManager: EntityManager
) {


    /*
    @Bean
    fun JPAQueryFactory(): JPAQueryFactory {
        return JPAQueryFactory(entityManager)
    }*/

}