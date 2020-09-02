package com.myth.ft_home.ui.tree

import com.myth.ft_home.api.RequestCenter
import com.myth.ft_home.model.TreeData
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient

class TreeRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getTreeList(): NetResult<MutableList<TreeData>> {
        return callRequest(call = { requestTreeList() })
    }

    private suspend fun requestTreeList() =
        handleResponse(service.create(RequestCenter::class.java).getTreeList())

}