package com.mk.zibchastocks.data.core.remote.utils

import com.mk.zibchastocks.data.core.remote.model.ApiResponse
import com.mk.zibchastocks.util.Result

suspend fun <T> safeApiCall(
    apiCall : suspend () -> ApiResponse<T>
): Result<T> {
    return try {
        val response  = apiCall()

        if (response.success){
            response.data?.let {
                Result.Success(it)
            } ?: Result.Error("Data is null")
        }else{
            Result.Error(response.message ?: "Unknown Message")
        }
    }catch (e : Exception){
        Result.Error(e.message ?: "Some exception occur")
    }
}