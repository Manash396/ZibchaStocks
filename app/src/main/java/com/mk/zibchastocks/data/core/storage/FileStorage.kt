package com.mk.zibchastocks.data.core.storage

import android.content.ContentValues
import android.content.Context
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import androidx.core.content.FileProvider
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class FileStorage(
    private val context : Context
) {

    fun savePdf(pdf : PdfDocument, fileName: String): Uri{
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            savePdfViaMediaStore(pdf, fileName)
        } else {
            savePdfViaFileSystem(pdf, fileName)
        }
    }

    fun saveJson(content: String, fileName: String): Uri {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            saveJsonViaMediaStore(content, fileName)
        } else {
            saveJsonViaFileSystem(content, fileName)
        }
    }

    fun saveCsv(content : String, fileName: String) : Uri{
        return  if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            saveCsvViaMediaStore(content, fileName)
        } else {
            saveCsvViaFileSystem(content, fileName)
        }
    }

    private fun saveJsonViaMediaStore(content: String, fileName: String): Uri {
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.txt")
            put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }

        val uri = context.contentResolver.insert(
            MediaStore.Files.getContentUri("external"),
            values
        ) ?: throw IOException("MediaStore Failed")

        context.contentResolver.openOutputStream(uri)?.use { outputStream ->
            outputStream.writer().use { writer ->
                writer.write(content)
            }
        }

        return uri
    }

    private fun saveJsonViaFileSystem(content: String, fileName: String): Uri {
        val downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        if (!downloadPath.exists()) downloadPath.mkdirs()

        val file = File(downloadPath, "$fileName.txt")

        file.writeText(content)

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )
    }
    private fun saveCsvViaMediaStore(content: String, fileName: String): Uri {
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.txt")
            put(MediaStore.MediaColumns.MIME_TYPE, "text/plain")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }

        val uri  = context.contentResolver.insert(
            MediaStore.Files.getContentUri("external"),
            values
        ) ?:  throw IOException("MediaStore Failed")

        context.contentResolver.openOutputStream(uri)?.use { outputStream ->
            outputStream.writer().use { writer ->
                writer.write(content)
            }
        }

        return uri
    }

    private fun saveCsvViaFileSystem(content: String, fileName: String): Uri {
        val downloadPath  = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        if (!downloadPath.exists()) downloadPath.mkdirs()

        val file  = File(downloadPath, "$fileName.txt")

        file.writeText(content)  // for text format

        return FileProvider.getUriForFile(
            context ,"${context.packageName}.provider" ,file
        )
    }

    private fun savePdfViaMediaStore(
        pdf: PdfDocument,
        fileName: String
    ): Uri {
        val values = ContentValues().apply {
            put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.pdf")
            put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
            put(MediaStore.MediaColumns.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS)
        }

        val uri = context.contentResolver.insert(
            MediaStore.Files.getContentUri("external"),
            values
        ) ?: throw IOException("MediaStore failed")   // uri is reference to the actual file space

        context.contentResolver.openOutputStream(uri)?.use {
            pdf.writeTo(it)   // it get converts to binary then saving it into the file
        }

        return uri
    }

    private fun savePdfViaFileSystem(
        pdf: PdfDocument,
        fileName: String
    ) : Uri {
        // direct access to the file folder
        val downloadPath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)

        if (!downloadPath.exists()) downloadPath.mkdirs()

        val file  = File(downloadPath, "$fileName.pdf")

        // this required for non-text format such as pdf
        FileOutputStream(file).use {
            pdf.writeTo(it)
        }

        return FileProvider.getUriForFile(
            context,
            "${context.packageName}.provider",
            file
        )
    }

}