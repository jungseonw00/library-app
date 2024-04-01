package com.group.libraryapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LibraryAppApplication

// 함수를 만들경우 static으로 처리됨
fun main(args: Array<String>) {
    runApplication<LibraryAppApplication>(*args)
}