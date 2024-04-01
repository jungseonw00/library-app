package com.group.libraryapp.domain.book

import com.group.libraryapp.domain.book.BookType.COMPUTER
import javax.persistence.Entity
import javax.persistence.EnumType.STRING
import javax.persistence.Enumerated
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id

// default parameter는 맨 아래에 있는게 관례임
@Entity
class Book(
    val name: String,

    @Enumerated(STRING)
    val type: BookType,

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("이름인 비어 있을 수 없습니다.")
        }
    }

    /**
     * 정적 팩토리 메서드 패턴을 사용하면, 필드가 추가되어도, 테스트 코드에 영향을 미치지 X(test fixture)
     * 클래스 가장 아래에 위치하는게 컨벤션
     */
    companion object {
        fun fixture(
            name: String = "책 이름",
            type: BookType = COMPUTER,
            id: Long? = null
        ): Book {
            return Book(
                name = name,
                type = type,
                id = id
            )
        }
    }
}

