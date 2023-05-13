package com.example.upload.controller

import com.example.upload.domain.Item
import com.example.upload.domain.ItemForm
import com.example.upload.domain.ItemRepository
import com.example.upload.file.FileStore
import org.slf4j.LoggerFactory
import org.springframework.core.io.Resource
import org.springframework.core.io.UrlResource
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.util.UriUtils
import java.nio.charset.StandardCharsets

@Controller
class ItemController(
    private val itemRepository: ItemRepository,
    private val fileStore: FileStore,
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @GetMapping("/items/new")
    fun newItem(@ModelAttribute form: ItemForm): String {
        return "item-form"
    }

    @PostMapping("/items/new")
    fun saveItem(@ModelAttribute form: ItemForm, redirectAttribute: RedirectAttributes): String {
        val attachFile = form.attachFile
            ?.let { fileStore.storeFile(it) }

        val storeImageFiles = form.imageFiles
            .let { fileStore.storeFiles(it) }

        val item = Item(itemName = form.itemName, attachFile = attachFile, imageFiles = storeImageFiles)
            .let { itemRepository.save(it) }

        redirectAttribute.addFlashAttribute("itemId", item.id)
        return "redirect:/items/${item.id}"
    }

    @GetMapping("/items/{id}")
    fun itesm(@PathVariable id: Long, model: Model): String {
        model.addAttribute("item", itemRepository.findById(id))
        return "item-view"
    }

    @ResponseBody
    @GetMapping("/images/{filename}")
    fun downloadImage(@PathVariable filename: String): Resource {
        return UrlResource("file:"+ fileStore.getFullPath(filename))
    }

    @GetMapping("/attach/{itemId}")
    fun getAttach(@PathVariable itemId: Long): ResponseEntity<Resource> {
        val item = itemRepository.findById(itemId)
        val storeFileName = item?.attachFile?.storeFileName ?: return ResponseEntity.notFound().build()
        val uploadFileName = item.attachFile?.uploadFileName ?: return ResponseEntity.notFound().build()

        val urlResource = UrlResource("file:" + fileStore.getFullPath(storeFileName))
        log.debug("uploadFileName {}", uploadFileName)
        val encode = UriUtils.encode(uploadFileName, StandardCharsets.UTF_8)
        val contentDisposition = "attachment; filename=\"$encode\""
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(urlResource)
    }
}