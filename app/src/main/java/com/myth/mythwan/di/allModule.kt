package com.myth.mythwan.di

import com.google.gson.GsonBuilder
import com.myth.ft_home.di.treeRepoModule
import com.myth.ft_home.di.treeViewModelModule
import com.myth.ft_login.di.loginRepoModule
import com.myth.ft_login.di.loginViewModelModule
import com.myth.ft_search.di.searchRepoModule
import com.myth.ft_search.di.searchViewModelModule
import com.myth.ft_tree_detail.di.detailRepoModule
import com.myth.ft_tree_detail.di.detailViewModelModule
import org.koin.dsl.module

/**
 *
 */
val otherModule = module {

    single {
        //        RetrofitClient.instance
    }

    single {
        GsonBuilder().disableHtmlEscaping().create()
    }
}

val allModule = listOf(
    otherModule,
    treeRepoModule, treeViewModelModule,
    loginRepoModule, loginViewModelModule,
    detailRepoModule, detailViewModelModule,
    searchRepoModule, searchViewModelModule

)