package com.example.upload.controller

import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.util.StreamUtils
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.nio.charset.StandardCharsets

@Controller
@RequestMapping("/servlet/v2")
class ServletUploadControllerV2 {
    @Value("\${file.dir}")
    private var fileDir: String? = null

    private val log = LoggerFactory.getLogger(this.javaClass.name)

    @GetMapping("/upload")
    fun newFile(): String = "upload-form"

    @PostMapping("/upload")
    fun saveFileV1(request: HttpServletRequest): String {
        val itemName = request.getParameter("itemName")
        log.debug(itemName)

        val parts = request.parts
        log.info("$parts")

        for (part in parts) {
            log.debug("=============Part")
            log.debug(part.name)
            val headerNames = part.headerNames
            for (headerName in headerNames) {
                log.debug("header {}: {}", headerName, part.getHeader(headerName))
            }
            val inputStream = part.inputStream
            val body = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8)
            log.debug("body : {}", body)

            if (StringUtils.hasText(part.submittedFileName)) {
                val fileSavePath = fileDir + part.submittedFileName
                log.debug("파일 저장 {}", fileSavePath)
                part.write(fileSavePath)
            }
        }

        return "upload-form"
    }
}

