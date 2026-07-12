package com.mk.zibchastocks.domain.export.usecase

import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.model.ExportRow
import com.mk.zibchastocks.domain.export.model.ExportType
import java.io.File

class ExportDataUseCase<T>(
    private val csvExporter: Exporter,
    private val jsonExporter: Exporter,
    private val pdfExporter: Exporter
) {

    fun execute(
        data: List<T>,
        type: ExportType,
        fileName: String
    ){


        when (type) {
            ExportType.CSV -> csvExporter.export(rows, fileName)
            ExportType.JSON -> jsonExporter.export(rows, fileName)
            ExportType.PDF -> pdfExporter.export(rows, fileName)
        }
    }

}