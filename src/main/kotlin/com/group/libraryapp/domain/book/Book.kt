package com.group.libraryapp.domain.book

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

// default parameter는 맨 아래에 있는게 관례임
@Entity
class Book(
    val name: String,


    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름인 비어 있을 수 없습니다.")
        }
    }
}