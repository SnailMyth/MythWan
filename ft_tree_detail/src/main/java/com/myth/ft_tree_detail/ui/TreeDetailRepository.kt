package com.myth.ft_tree_detail.ui

import com.myth.ft_tree_detail.model.TreeDetailModel
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient
import com.myth.ft_tree_detail.api.RequestCenter


/**
 * @author : myth_hai
 * @date : 2020/9/3 11:31
 * @description : TreeDetailRepository
 */
class TreeDetailRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getTreeDetailList(count: Int, cid: Int): NetResult<TreeDetailModel> {

        return callRequest(call = { requestTreeDetailList(count, cid) })
    }

    private suspend fun requestTreeDetailList(count: Int, cid: Int) =
        handleResponse(
            service.create(RequestCenter::class.java).getTreeDetailList(count, cid)
        )
}