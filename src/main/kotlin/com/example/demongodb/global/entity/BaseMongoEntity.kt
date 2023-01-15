package com.example.demongodb.global.entity

import com.querydsl.core.annotations.QueryExclude
import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import java.util.*

@QueryExclude
@MappedSuperclass
class BaseMongoEntity {

    @Id
    var id: UUID = UUID.randomUUID()
        protected set

}