package com.example.upload.domain

import org.springframework.stereotype.Repository

@Repository
class ItemRepository {

    private val store = HashMap<Long, Item>()
    private var sequence = 0L

    fun save(item: Item): Item {
        item.id = ++sequence
        item.id?.let { store[it] = item }
        return item
    }

    fun findById(id: Long): Item? {
        return store[id]
    }
}