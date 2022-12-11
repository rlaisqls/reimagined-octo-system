package com.example.demongodb.global.config


import com.mongodb.client.MongoClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.MongoDatabaseFactory
import org.springframework.data.mongodb.config.EnableMongoAuditing
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories


@Configuration
@EnableMongoRepositories(basePackages = ["com.example.demongodb"], mongoTemplateRef = "blogMongoTemplate")
@EnableMongoAuditing
class MongoDBConfig {

    @Bean
    fun blogMongoTemplate(mongoClient: MongoClient): MongoTemplate {
        val factory: MongoDatabaseFactory = SimpleMongoClientDatabaseFactory(mongoClient, "blog")
        return MongoTemplate(factory)
    }

}