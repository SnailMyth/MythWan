package com.myth.ft_home.model

import com.myth.lib_base.model.DataBean

data class DataFeed(
    val curPage: Int,
    val offset: Int,
    val pageCount: Int,
    val size: Int,
    val total: Int,
    val over: Boolean,
    val data: MutableList<DataBean>
)