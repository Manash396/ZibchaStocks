package com.mk.zibchastocks.domain.export.exporter

import com.mk.zibchastocks.domain.export.model.ExportRow

interface Exporter {
    fun export(
        rows: List<ExportRow>,
        fileName: String
    )
}