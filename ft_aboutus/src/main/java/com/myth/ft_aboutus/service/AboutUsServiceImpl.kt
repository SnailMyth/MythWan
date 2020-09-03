package com.myth.ft_aboutus.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.myth.ft_aboutus.ui.AboutUsActivity
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.aboutus.AboutUsService

/**
 * @author : myth_hai
 * @date : 2020/9/3 12:01
 * @description : AboutUsServiceImpl
 */
@Route(path = ConstantsPath.ABOUT_US_SERVICE_PATH)
class AboutUsServiceImpl : AboutUsService {

    override fun start(context: Context) {
        AboutUsActivity.start(context)
    }

    override fun init(context: Context) {

    }

}