package com.example.demongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.example.demongodb.domain.user", "com.example.demongodb.domain.student"])
class DemongoDbApplication

fun main(args: Array<String>) {
    runApplication<DemongoDbApplication>(*args)
}
