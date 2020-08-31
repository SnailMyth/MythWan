package com.myth.lib_net.net

import com.myth.lib_net.exception.DealException
import com.myth.lib_net.exception.ResultException
import com.myth.lib_net.model.BaseModel
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

open class BaseRepository {

    // TODO: 2020/8/31  suspend
    suspend fun <T : Any> callRequest(
        call: suspend () -> NetResult<T>
    ): NetResult<T> {
        return try {
            call()
        } catch (e: Exception) {
            //这里统一处理异常
            e.printStackTrace()
            NetResult.Error(DealException.handlerException(e))
        }
    }

    suspend fun <T : Any> handleResponse(
        response: BaseModel<T>,
        successBlock: (suspend CoroutineScope.() -> Unit)? = null,
        errorBlock: (suspend CoroutineScope.() -> Unit)? = null
    ): NetResult<T> {
        return coroutineScope {
            if (response.errorCode == -1) {
                errorBlock?.let { it() }
                NetResult.Error(
                    ResultException(
                        response.errorCode.toString(),
                        response.errorMsg
                    )
                )
            } else {
                successBlock?.let { it() }
                NetResult.Success(response.data)
            }
        }
    }


}