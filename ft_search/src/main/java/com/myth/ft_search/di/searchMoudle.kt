package com.myth.ft_search.di


import com.myth.ft_search.ui.HotKeyViewModel
import com.myth.ft_search.ui.SearchRepository
import com.myth.ft_search.ui.SearchResultViewModel
import com.myth.ft_search.ui.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:04
 * @description : searchModule
 */
val searchRepoModule = module {
    single {
        SearchRepository(get())
    }
}

val searchViewModelModule = module {

    viewModel {
        SearchViewModel(get())
    }
    viewModel {
        HotKeyViewModel(get())
    }

    viewModel { SearchResultViewModel(get()) }
}