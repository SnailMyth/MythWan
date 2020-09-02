package com.myth.lib_base.service.webview

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:18
 * @description : WebViewService
 */
interface WebViewService : IProvider {

    fun start(
        context: Context, title: String
        , url: String
    )
}