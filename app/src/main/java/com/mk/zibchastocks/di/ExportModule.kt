package com.mk.zibchastocks.di

import android.content.Context
import com.mk.zibchastocks.data.export.csv.CsvExporter
import com.mk.zibchastocks.data.export.json.JsonExporter
import com.mk.zibchastocks.data.export.pdf.PdfExporter
import com.mk.zibchastocks.data.storage.FileStorage
import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.model.ExportType
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
object ExportModule {

    @Provides
    fun provideFileStorage(
        @ApplicationContext context: Context
    ) : FileStorage = FileStorage(context)

    @Provides
    @IntoMap
    @ExportKey(ExportType.CSV)
    fun provideCsvExporter(
        fileStorage: FileStorage
    ) : Exporter = CsvExporter(fileStorage)


    @Provides
    @IntoMap
    @ExportKey(ExportType.PDF)
    fun providePdfExporter(
        fileStorage: FileStorage
    ) : Exporter = PdfExporter(fileStorage)

    @Provides
    @IntoMap
    @ExportKey(ExportType.JSON)
    fun provideJsonExporter(
        fileStorage: FileStorage
    ) : Exporter = JsonExporter(fileStorage)





}