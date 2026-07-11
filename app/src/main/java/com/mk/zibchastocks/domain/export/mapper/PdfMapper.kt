package com.mk.zibchastocks.domain.export.mapper

import com.mk.zibchastocks.domain.export.model.PdfRow

interface PdfMapper<T> {
    fun map(data: T) : PdfRow
}