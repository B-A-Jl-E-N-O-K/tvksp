package ru.zverev.springmirea

import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class ItemController(private val itemRepository: ItemRepository) {

    @PostMapping("/items")
    fun addItem(@RequestBody item: Item): ResponseEntity<Item> {
        val savedItem = itemRepository.save(item)
        return ResponseEntity.ok(savedItem)
    }

    @GetMapping("/items")
    fun getAllItems(): ResponseEntity<List<Item>> {
        val items = itemRepository.findAll()
        return ResponseEntity.ok(items)
    }

    @GetMapping("/logo", produces = [MediaType.IMAGE_PNG_VALUE])
    fun getLogo(): ResponseEntity<ByteArray> {
        val resource = ClassPathResource("image/MIREA_Gerb_Colour.png")
        return ResponseEntity.ok(resource.inputStream.readBytes())
    }
}