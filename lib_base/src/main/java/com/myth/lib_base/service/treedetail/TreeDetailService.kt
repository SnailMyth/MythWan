package com.myth.lib_base.service.treedetail

import android.content.Context
import com.alibaba.android.arouter.facade.template.IProvider

/**
 * @author : myth_hai
 * @date : 2020/9/2 14:39
 * @description : TreeDetailService
 */
interface TreeDetailService : IProvider {

    fun start(context: Context, cid: Int, title: String)

}