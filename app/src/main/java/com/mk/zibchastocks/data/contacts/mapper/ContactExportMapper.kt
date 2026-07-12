package com.mk.zibchastocks.data.contacts.mapper

import com.mk.zibchastocks.domain.contacts.model.Contact
import com.mk.zibchastocks.domain.export.mapper.ExportMapper
import com.mk.zibchastocks.domain.export.model.ExportRow
import com.mk.zibchastocks.util.AppConstant
import javax.inject.Inject

class ContactExportMapper @Inject constructor() : ExportMapper<Contact> {

    override fun map(data: Contact): ExportRow {
        return ExportRow(
            mapOf(
                AppConstant.Contact.NAME to data.name,
                AppConstant.Contact.PHONE to data.phone
            )
        )
    }

}