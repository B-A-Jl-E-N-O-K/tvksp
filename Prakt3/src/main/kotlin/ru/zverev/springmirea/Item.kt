package ru.zverev.springmirea

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id

@Entity
class Item(
    @Id @GeneratedValue
    val id: Long = 0,

    val name: String
)
