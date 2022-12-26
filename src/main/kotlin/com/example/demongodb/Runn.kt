package com.example.demongodb

import org.springframework.boot.CommandLineRunner
import org.springframework.context.ApplicationContext
import org.springframework.stereotype.Component
import java.util.*

@Component
class Runn(
    private val ac: ApplicationContext
): CommandLineRunner {
    override fun run(args: Array<String>) {
        val beans = ac.beanDefinitionNames;
        Arrays.sort(beans)

        for(i in beans.indices) {
            println(beans[i])
        }
    }
}