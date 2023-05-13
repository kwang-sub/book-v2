package com.example.upload.controller

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.multipart.MultipartFile
import java.io.File

@Controller
@RequestMapping("/spring")
class SpringUploadController {
    @Value("\${file.dir}")
    private var fileDir: String? = null

    private val log = LoggerFactory.getLogger(this.javaClass.name)

    @GetMapping("/upload")
    fun newFile(): String = "upload-form"

    @PostMapping("/upload")
    fun saveFile(@RequestParam itemName: String, @RequestParam file: MultipartFile): String {
        log.debug(itemName)
        log.debug(file.toString())
        if (!file.isEmpty) {
            val fileSavePath = fileDir + file.originalFilename
            log.info("파일 저장 full path = {}", fileSavePath)
            file.transferTo(File(fileSavePath))
        }

        return "upload-form"
    }
}