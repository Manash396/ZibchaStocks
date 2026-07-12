package com.mk.zibchastocks.di

import com.mk.zibchastocks.domain.export.model.ExportType
import dagger.MapKey

@MapKey
annotation class ExportKey(val value: ExportType)