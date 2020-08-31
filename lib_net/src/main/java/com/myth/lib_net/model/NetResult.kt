package com.myth.lib_net.model

import com.myth.lib_net.exception.ResultException

// TODO: 2020/8/31 sealed Any
sealed class NetResult<out T : Any> {

    data class Success<out T : Any>(val data: T) : NetResult<T>()

    data class Error(val exception: ResultException) : NetResult<Nothing>()

}