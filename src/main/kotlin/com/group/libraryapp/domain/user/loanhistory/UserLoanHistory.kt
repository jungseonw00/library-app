package com.group.libraryapp.domain.user.loanhistory

import com.group.libraryapp.domain.user.User
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus.LOANED
import com.group.libraryapp.domain.user.loanhistory.UserLoanStatus.RETURNED
import javax.persistence.*
import javax.persistence.EnumType.STRING
import javax.persistence.GenerationType.IDENTITY

@Entity
class UserLoanHistory(
    @ManyToOne
    val user: User,

    val bookName: String,

    @Enumerated(STRING)
    var status: UserLoanStatus = LOANED,

    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = null
) {

    val isReturn: Boolean
        get() = this.status == RETURNED

    fun doReturn() {
        this.status = RETURNED
    }

    companion object {
        fun fixture(
            user: User,
            bookName: String = "이상한 나라의 엘리스",
            status: UserLoanStatus = LOANED,
            id: Long? = null
        ): UserLoanHistory {
            return UserLoanHistory(
                user = user,
                bookName = bookName,
                status = status,
                id = id
            )
        }
    }
}