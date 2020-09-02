package com.myth.lib_base.service.webview.wrap

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.webview.WebViewService

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:18
 * @description : WebViewWarpService
 */
class WebViewWarpService private constructor() {

    @Autowired(name = ConstantsPath.WEB_VIEW_SERVICE_PATH)
    lateinit var service: WebViewService


    init {
        ARouter.getInstance().inject(this)
    }

    companion object {

        val instance = Singleton.holder

        object Singleton {
            val holder = WebViewWarpService()
        }

    }

    fun start(context: Context, title: String, url: String) {
        service.start(context, title, url)
    }

}