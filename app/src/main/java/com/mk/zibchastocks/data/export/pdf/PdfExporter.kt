package com.mk.zibchastocks.data.export.pdf

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import com.mk.zibchastocks.data.storage.FileStorage
import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.model.ExportRow

class PdfExporter(
    private val fileStorage: FileStorage
) : Exporter{

    override fun export(rows: List<ExportRow>, fileName: String) {
        if(rows.isEmpty()) return

        val pdfDocument = PdfDocument()
        val paint = Paint().apply {
            color = Color.BLUE
        }

        val pageWight = 1200
        val pageHeight= 2000    //  1 point = 1/72 inch

        val columnSpacing = 250
        val rowSpacing  = 40

        val headers = rows.first().columns.keys.toList()
        var pageNumber  = 1
        var y =  50

        var pageInfo = PdfDocument.PageInfo.Builder(pageWight, pageHeight, pageNumber).create()
        var page  = pdfDocument.startPage(pageInfo)
        var canvas = page.canvas

        // function to draw header
        fun drawHeaders() {
            var x = 50
            headers.forEachIndexed { index, header ->
                canvas.drawText(header, (x + (index*columnSpacing)).toFloat(), y.toFloat() , paint )
            }
            y+= rowSpacing
        }

        drawHeaders()

        rows.forEach { row ->
            // check if page is full or what
            if(y>pageHeight-50){
                // new page required
                pdfDocument.finishPage(page)

                pageNumber++

                pageInfo = PdfDocument.PageInfo.Builder(pageWight,pageHeight,pageNumber).create()
                page =  pdfDocument.startPage(pageInfo)
                canvas = page.canvas

                y = 50

                // draw the headers
                drawHeaders()
                paint.color = Color.BLACK
            }

            var x  = 50

            // need the keys
            headers.forEachIndexed { index, headKey ->
                val columnValue = row.columns[headKey] ?: ""
                canvas.drawText(columnValue,x + (index * columnSpacing).toFloat() ,y.toFloat() , paint)
            }

            y+= rowSpacing

        }

        pdfDocument.finishPage(page)

        // think pdfDocument as a editor after exporting the content it need to be close to prevent memory leaking
        fileStorage.savePdf(pdfDocument,fileName)

        pdfDocument.close()
    }

}