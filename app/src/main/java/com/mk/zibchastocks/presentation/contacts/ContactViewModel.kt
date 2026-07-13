package com.mk.zibchastocks.presentation.contacts

import com.mk.zibchastocks.domain.contacts.usecase.GetContactsUseCase
import com.mk.zibchastocks.domain.export.usecase.ExportDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContactsUseCase: GetContactsUseCase,
    private val exportDataUseCase: ExportDataUseCase
) {
}