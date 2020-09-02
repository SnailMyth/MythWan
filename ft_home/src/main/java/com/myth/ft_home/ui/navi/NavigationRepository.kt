package com.myth.ft_home.ui.navi

import com.myth.ft_home.api.RequestCenter
import com.myth.ft_home.model.navigation.NavigationItem
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient

class NavigationRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getNavigationData(): NetResult<MutableList<NavigationItem>> {
        return callRequest(call = { requestNavigationData() })
    }

    private suspend fun requestNavigationData(): NetResult<MutableList<NavigationItem>> =
        handleResponse(service.create(RequestCenter::class.java).getNavigationData())

}