package com.myth.ft_tree_detail.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.myth.ft_tree_detail.ui.TreeDetailActivity
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.treedetail.TreeDetailService


/**
 * @author : myth_hai
 * @date : 2020/9/3 11:50
 * @description : TreeDetailServiceImpl
 */
@Route(path = ConstantsPath.TREE_DETAIL_SERVICE_PATH)
class TreeDetailServiceImpl :
    TreeDetailService {
    override fun start(context: Context, cid: Int, title: String) {
        TreeDetailActivity.start(context, cid, title)
    }


    override fun init(context: Context?) {

    }
}