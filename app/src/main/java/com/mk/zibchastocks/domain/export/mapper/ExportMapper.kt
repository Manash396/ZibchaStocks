package com.mk.zibchastocks.domain.export.mapper

import com.mk.zibchastocks.domain.export.model.ExportRow

interface ExportMapper<T> {
    fun map(data: T) : ExportRow
}