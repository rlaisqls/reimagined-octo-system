package com.example.demongodb.global.entity


import jakarta.persistence.Id
import jakarta.persistence.MappedSuperclass
import org.bson.types.ObjectId


@MappedSuperclass
class BaseObjectEntity {

    @Id
    var id: ObjectId = ObjectId()

}