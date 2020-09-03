package com.myth.ft_search.ui

import com.myth.ft_search.api.RequestCenter
import com.myth.ft_search.model.HotKeyModel
import com.myth.ft_search.model.SearchResultModel
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient


/**
 * @author : myth_hai
 * @date : 2020/9/3 11:04
 * @description : SearchRepository
 */
class SearchRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getHotKey(): NetResult<MutableList<HotKeyModel>> {
        return callRequest(call = { requestHotKey() })
    }

    suspend fun search(page: Int, key: String): NetResult<SearchResultModel> {
        return callRequest(call = { requestSearch(page, key) })
    }

    private suspend fun requestHotKey() =
        handleResponse(service.create(RequestCenter::class.java).getHotKey())


    private suspend fun requestSearch(page: Int, key: String) =
        handleResponse(service.create(RequestCenter::class.java).search(page, key))


}