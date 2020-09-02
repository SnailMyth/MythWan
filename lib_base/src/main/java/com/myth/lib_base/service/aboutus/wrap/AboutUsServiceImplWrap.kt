package com.myth.lib_base.service.aboutus.wrap

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.launcher.ARouter
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.aboutus.AboutUsService

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:24
 * @description : AboutUsServiceImplWrap
 */
object AboutUsServiceImplWrap {

    @Autowired(name = ConstantsPath.ABOUT_US_SERVICE_PATH)
    lateinit var service: AboutUsService

    init {
        ARouter.getInstance().inject(this)
    }

    fun start(context: Context) {
        return service.start(context)
    }


}