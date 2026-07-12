package com.mk.zibchastocks.data.export.csv

import com.mk.zibchastocks.data.storage.FileStorage
import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.model.ExportRow

class CsvExporter(
    private val fileStorage: FileStorage
) : Exporter{

    override fun export(rows: List<ExportRow>, fileName: String
    ) {
        if (rows.isEmpty()) return

        val headers = rows.first().columns.keys.toList()

        val csvBuilder  = StringBuilder()

        // adding headers first followed by column
        csvBuilder.append(headers.joinToString(","))
        csvBuilder.append("\n")

        rows.forEach { row ->
            val line = headers.joinToString { key ->
                val value  = row.columns[key] ?: ""
                escapeCsv(value)
            }
            csvBuilder.append(line)
            csvBuilder.append("\n")
        }

        fileStorage.saveCsv(csvBuilder.toString() , fileName)
    }

    private fun escapeCsv(value: String): String {
        return if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            "\"${value.replace("\"", "\"\"")}\""
        } else {
            value
        }
    }

}