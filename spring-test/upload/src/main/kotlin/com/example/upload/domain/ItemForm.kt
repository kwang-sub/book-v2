package com.example.upload.domain

import org.springframework.web.multipart.MultipartFile

data class ItemForm(
    var itemId: Long?,
    var itemName: String?,
    var imageFiles: MutableList<MultipartFile> = mutableListOf(),
    var attachFile: MultipartFile?,
)