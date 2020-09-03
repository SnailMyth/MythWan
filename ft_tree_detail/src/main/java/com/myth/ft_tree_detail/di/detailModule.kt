package com.myth.ft_tree_detail.di

import com.myth.ft_tree_detail.ui.TreeDetailRepository
import com.myth.ft_tree_detail.ui.TreeDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:40
 * @description : detailModule
 */

val detailRepoModule = module {
    factory {
        TreeDetailRepository(get())
    }
}

val detailViewModelModule = module {
    viewModel {
        TreeDetailViewModel(get())
    }
}
