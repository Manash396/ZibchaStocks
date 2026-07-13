package com.mk.zibchastocks.di

import com.mk.zibchastocks.domain.export.model.ExportType
import dagger.MapKey

// this is use for multibinding if same interface is implemented by more than one
@MapKey
annotation class ExportKey(val value: ExportType)