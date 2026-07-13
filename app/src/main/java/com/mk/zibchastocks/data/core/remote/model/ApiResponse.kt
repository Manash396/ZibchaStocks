package com.mk.zibchastocks.data.core.remote.model

data class ApiResponse<T>(
    val success : Boolean,
    val message: String?,
    val data: T? = null
)
