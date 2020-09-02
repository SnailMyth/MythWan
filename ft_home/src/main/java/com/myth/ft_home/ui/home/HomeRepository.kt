package com.myth.ft_home.ui.home

import com.myth.ft_home.api.RequestCenter
import com.myth.ft_home.model.Banner
import com.myth.ft_home.model.DataFeed
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient

/**
 * @author : myth_hai
 * @date : 2020/9/2 16:22
 * @description : HomeRepository
 */
class HomeRepository(private val service: RetrofitClient):BaseRepository(){


    suspend fun getBanner(): NetResult<List<Banner>> {
        return callRequest(call = { requestBanner() })
    }

    suspend fun getHomeList(count: Int): NetResult<DataFeed> {
        return callRequest(call = { requestHomeList(count) })
    }

    private suspend fun requestBanner() =
        handleResponse(service.create(RequestCenter::class.java).getBanner())

    private suspend fun requestHomeList(count: Int) =
        handleResponse(
            service.create(RequestCenter::class.java).getHomeList(count)
        )

}