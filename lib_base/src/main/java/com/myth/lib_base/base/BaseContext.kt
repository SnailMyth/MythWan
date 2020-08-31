package com.myth.lib_base.base

import android.content.Context

/**
 * @author : myth_hai
 * @date : 2020/8/31 17:37
 * @description : BaseContext
 */
class BaseContext private constructor() {
    //TODO lateinit
    private lateinit var mContext: Context

    fun init(context: Context) {
        mContext = context;
    }


    fun getContext(): Context {
        return mContext
    }


    //companion object 创建实例
    companion object {
        val instance = Singleton.holder
        object Singleton {
            val holder = BaseContext()
        }
    }

}
