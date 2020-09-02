package com.myth.ft_home.di

import com.myth.ft_home.ui.home.HomeListViewModel
import com.myth.ft_home.ui.home.HomeRepository
import com.myth.ft_home.ui.home.HomeViewModel
import com.myth.ft_home.ui.main.MainViewModel
import com.myth.ft_home.ui.mine.MineViewModel
import com.myth.ft_home.ui.navi.NavigationDataPageViewModel
import com.myth.ft_home.ui.navi.NavigationRepository
import com.myth.ft_home.ui.navi.NavigationViewModel
import com.myth.ft_home.ui.project.ProjectRepository
import com.myth.ft_home.ui.project.ProjectViewModel
import com.myth.ft_home.ui.project.TabItemViewModel
import com.myth.ft_home.ui.tree.TreeRepository
import com.myth.ft_home.ui.tree.TreeViewModel

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author : myth_hai
 * @date : 2020/9/2 17:55
 * @description : mainModule
 */
val treeRepoModule = module {
    single { TreeRepository(get()) }
    single { HomeRepository(get()) }
    single { ProjectRepository(get()) }
    single { NavigationRepository(get()) }
}


val treeViewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { TreeViewModel(get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { ProjectViewModel(get()) }
    viewModel { TabItemViewModel(get()) }
    viewModel { MineViewModel() }
    viewModel { NavigationViewModel(get()) }
    viewModel { NavigationDataPageViewModel() }
    viewModel { HomeListViewModel(get()) }
}

