package com.example.demongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = [com.example.demongodb.domain.user.domain.repository.UserRepository::class])
class DemongoDbApplication

fun main(args: Array<String>) {
    runApplication<DemongoDbApplication>(*args)
}
