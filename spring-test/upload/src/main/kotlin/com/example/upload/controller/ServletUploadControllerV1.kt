package com.example.upload.controller

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/servlet/v1")
class ServletUploadControllerV1 {
    private val log = LoggerFactory.getLogger(this.javaClass.name)

    @GetMapping("/upload")
    fun newFile(): String = "upload-form"

    @PostMapping("/upload")
    fun saveFileV1(request: HttpServletRequest): String {
        val itemName = request.getParameter("itemName")
        log.debug(itemName)

        val parts = request.parts
        log.info("$parts")

        return "upload-form"
    }
}

