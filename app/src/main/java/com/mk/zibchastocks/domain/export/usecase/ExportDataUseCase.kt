package com.mk.zibchastocks.domain.export.usecase

import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.mapper.ExportMapper
import com.mk.zibchastocks.domain.export.model.ExportType
import javax.inject.Inject

class ExportDataUseCase @Inject constructor(
    private val exporters : Map<ExportType , @JvmSuppressWildcards Exporter>,
) {

    fun <T> execute(
        data: List<T>,
        mapper : ExportMapper<T>,
        exportType: ExportType,
        fileName: String
    ){
        val rows = data.map { mapper.map(it) }

        val exporter = exporters[exportType]
            ?: throw IllegalArgumentException("Exporter not found")

        exporter.export(rows, fileName)
    }

}