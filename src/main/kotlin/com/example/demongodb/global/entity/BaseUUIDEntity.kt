package com.example.demongodb.global.entity


import jakarta.persistence.Column
import jakarta.persistence.GeneratedValue
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.GenericGenerator
import org.springframework.data.annotation.Id
import java.util.*

@MappedSuperclass
class BaseUUIDEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID = UUID(0,0)

}