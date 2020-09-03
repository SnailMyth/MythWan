package com.myth.ft_search.api

import com.myth.ft_search.model.HotKeyModel
import com.myth.ft_search.model.SearchResultModel
import com.myth.lib_net.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:05
 * @description : RequestCenter
 */
interface RequestCenter {

    @GET("/hotkey/json")
    suspend fun getHotKey(): BaseModel<MutableList<HotKeyModel>>


    @POST(" /article/query/{page}/json")
    suspend fun search(
        @Path("page") page: Int,
        @Query("k") key: String
    ): BaseModel<SearchResultModel>

}