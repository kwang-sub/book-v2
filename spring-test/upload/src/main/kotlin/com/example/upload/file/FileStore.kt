package com.example.upload.file

import com.example.upload.domain.UploadFile
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.util.*

@Component
class FileStore {

    @Value("\${file.dir}")
    private var fileDir: String? = null

    fun getFullPath(fileName: String): String {
        return fileDir + fileName
    }

    fun storeFiles(multipartFiles: MutableCollection<MultipartFile>): MutableList<UploadFile> {
        val storeFileResult = mutableListOf<UploadFile>()
        for (multipartFile in multipartFiles) {
            storeFile(multipartFile)
                ?.let { storeFileResult.add(it) }
        }
        return storeFileResult
    }

    fun storeFile(multipartFile: MultipartFile): UploadFile? {
        if (multipartFile.isEmpty) return null

        val originalFilename = multipartFile.originalFilename ?: return null
        val storeFileName = createStoreFileName(originalFilename)

        multipartFile.run { transferTo(File(getFullPath(storeFileName))) }

        return UploadFile(originalFilename, storeFileName)
    }

    private fun createStoreFileName(originalFilename: String): String {
        val uuid = UUID.randomUUID().toString()
        val ext = originalFilename.substringAfterLast(".")
        return "$uuid.$ext"
    }

}