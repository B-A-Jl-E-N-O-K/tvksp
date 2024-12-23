package ru.zverev.springmirea

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : JpaRepository<Item, Long>