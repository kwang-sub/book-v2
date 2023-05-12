package com.example.upload.controller

import jakarta.servlet.http.HttpServletRequest
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/servlet/v1")
class ServletUploadControllerV1 {

    @GetMapping("/upload")
    fun newFile(): String = "upload-form"

    @PostMapping("/upload")
    fun saveFileV1(request: HttpServletRequest): String {
        val itemName = request.getParameter("itemName")
        println(itemName)

        val parts = request.parts
        println(parts)

        return "upload-form"
    }
}