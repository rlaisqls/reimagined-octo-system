package com.example.demongodb.domain.document.domain.element

class IntroduceElement (

    title: String = "",
    introduce: String = "",
    skillSet: List<String> = listOf(),
    linkList: List<LinkElement> = listOf()

) {
    var title: String = title
        protected set

    var introduce: String = introduce
        protected set

    var skillSet: List<String> = skillSet
        protected set

    var linkList: List<LinkElement>  = linkList
        protected set

}