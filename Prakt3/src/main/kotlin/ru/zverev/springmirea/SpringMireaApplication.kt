package ru.zverev.springmirea

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringMireaApplication

fun main(args: Array<String>) {
    runApplication<SpringMireaApplication>(*args)
}
