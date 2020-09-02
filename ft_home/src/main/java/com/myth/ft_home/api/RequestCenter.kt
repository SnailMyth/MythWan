package com.myth.ft_home.api


import com.myth.ft_home.model.*
import com.myth.ft_home.model.navigation.NavigationItem
import com.myth.lib_net.model.BaseModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author : myth_hai
 * @date : 2020/9/2 15:49
 * @description : RequestCenter
 */
interface RequestCenter {

    @GET("/banner/json")
    suspend fun getBanner(): BaseModel<MutableList<Banner>>

    @GET("/article/list/{count}/json")
    suspend fun getHomeList(@Path("count") count: Int): BaseModel<DataFeed>

    @GET("/tree/json")
    suspend fun getTreeList(): BaseModel<MutableList<TreeData>>

    @GET("/project/tree/json")
    suspend fun getTabData(): BaseModel<MutableList<ProjectTabItem>>

    @GET("/project/list/{count}/json")
    suspend fun getTabItemPageData(
        @Path("count") count: Int,
        @Query("cid") cid: Int
    ): BaseModel<ProjectPageItem>


    @GET("/navi/json")
    suspend fun getNavigationData(): BaseModel<MutableList<NavigationItem>>

}