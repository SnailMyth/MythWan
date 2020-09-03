package com.myth.mythwan

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.myth.mythwan.di.allModule
import com.tencent.mmkv.MMKV
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MythApp : Application() {

    override fun onCreate() {
        super.onCreate()

//        BaseContext.instance.init(this)
        ARouter.init(this)
        MMKV.initialize(this)

        startKoin {
            androidContext(this@MythApp)
            modules(allModule)
        }

    }
}