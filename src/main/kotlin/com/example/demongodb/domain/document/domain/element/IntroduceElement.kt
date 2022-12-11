package com.example.demongodb.domain.document.domain.element

class IntroduceElement (
    val title: String = "",
    val introduce: String = "",
    val skillSet: MutableList<String> = mutableListOf(),
    val linkList: MutableList<LinkElement> = mutableListOf()
)