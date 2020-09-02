package com.myth.ft_home.presenter

import android.content.Context
import com.myth.lib_base.service.webview.wrap.WebViewWarpService

/**
 * @author : myth_hai
 * @date : 2020/9/2 17:33
 * @description : HandlerClick
 */
object HandlerClick {

    fun navigationItemClick(context: Context, title: String, url: String) {
        WebViewWarpService.instance.start(context, title, url)
    }

}