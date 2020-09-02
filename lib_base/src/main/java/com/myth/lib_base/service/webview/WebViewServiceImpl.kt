package com.myth.lib_base.service.webview

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.myth.lib_base.base.WebViewActivity
import com.myth.lib_base.service.ConstantsPath

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:18
 * @description : WebViewServiceImpl
 */
@Route(path = ConstantsPath.WEB_VIEW_SERVICE_PATH)
class WebViewServiceImpl : WebViewService {

    override fun start(context: Context, title: String, url: String) {
        WebViewActivity.start(context, title, url)
    }

    override fun init(context: Context?) {

    }

}