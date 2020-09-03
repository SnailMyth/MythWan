package com.myth.ft_tree_detail.api

import com.myth.ft_tree_detail.model.TreeDetailModel
import com.myth.lib_net.model.BaseModel
import retrofit2.http.*

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:31
 * @description : RequestCenter
 */
interface RequestCenter {

    @GET(value = "/article/list/{count}/json")
    suspend fun getTreeDetailList(
        @Path("count") count: Int,
        @Query("cid") cid: Int
    ): BaseModel<TreeDetailModel>



}