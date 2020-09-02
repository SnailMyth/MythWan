package com.myth.lib_base.service.search

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author : myth_hai
 * @date : 2020/9/2 14:39
 * @description : SearchService
 */
interface SearchService : IProvider {

    fun start(context: Context)

}