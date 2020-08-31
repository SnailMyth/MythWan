package com.myth.lib_net.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * @author : myth_hai
 * @date : 2020/8/31 18:16
 * @description : CommonInterceptor 共用拦截器 可以添加公共参数
 */
class CommonInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val builder = addHeaders(request.newBuilder())

        return chain.proceed(builder)

    }

    private fun addHeaders(builder: Request.Builder): Request {
        return builder.addHeader("Content_Type", "application/json")
            .addHeader("charset", "UTF-8").build()
    }
}