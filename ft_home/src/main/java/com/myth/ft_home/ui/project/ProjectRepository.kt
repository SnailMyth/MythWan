package com.myth.ft_home.ui.project

import com.myth.ft_home.api.RequestCenter
import com.myth.ft_home.model.ProjectPageItem
import com.myth.ft_home.model.ProjectTabItem
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient

/**
 * @author : myth_hai
 * @date : 2020/9/2 17:00
 * @description : ProjectRepository
 */
class ProjectRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun getTabData(): NetResult<MutableList<ProjectTabItem>> {
        return callRequest(call = { requestTabData() })
    }

    private suspend fun requestTabData() =
        handleResponse(service.create(RequestCenter::class.java).getTabData())


    suspend fun getTabItemPageData(count: Int, id: Int): NetResult<ProjectPageItem> {
        return callRequest(call = { requestTabItemPageData(count, id) })
    }

    private suspend fun requestTabItemPageData(count: Int, id: Int) =
        handleResponse(
            service.create(RequestCenter::class.java).getTabItemPageData(count, id)
        )


}