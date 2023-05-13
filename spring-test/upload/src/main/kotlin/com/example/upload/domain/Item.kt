package com.example.upload.domain

data class Item(
    var id: Long? = null,
    var itemName: String? = null,
    var attachFile: UploadFile? = null,
    var imageFiles: MutableList<UploadFile> = mutableListOf()
)