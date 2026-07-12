package com.mk.zibchastocks.data.export.json

import com.mk.zibchastocks.data.storage.FileStorage
import com.mk.zibchastocks.domain.export.exporter.Exporter
import com.mk.zibchastocks.domain.export.model.ExportRow
import org.json.JSONArray
import org.json.JSONObject

class JsonExporter(
    private val fileStorage: FileStorage
) : Exporter{

    override fun export(
        rows: List<ExportRow>,
        fileName: String
    ) {
        if (rows.isEmpty()) return

        val jsonArray  = JSONArray()

        rows.forEach { row ->
            val jsonObject = JSONObject()
            row.columns.forEach { col, value ->
                jsonObject.put(col,value)
            }
            jsonArray.put(jsonObject)
        }

        fileStorage.saveJson(jsonArray.toString() , fileName)
    }

}