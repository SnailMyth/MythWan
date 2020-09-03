package com.myth.ft_search.service

import android.content.Context
import com.alibaba.android.arouter.facade.annotation.Route
import com.myth.ft_search.ui.SearchActivity
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.search.SearchService

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:24
 * @description : SearchServiceImpl
 */
@Route(path = ConstantsPath.SEARCH_SERVICE_PATH)
class SearchServiceImpl : SearchService {

    override fun start(context: Context) {
        SearchActivity.start(context)
    }

    override fun init(context: Context?) {

    }
}