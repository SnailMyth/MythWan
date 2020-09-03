package com.myth.ft_login.di


import com.myth.ft_login.ui.LoginRepository
import com.myth.ft_login.ui.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * @author : myth_hai
 * @date : 2020/9/3 10:31
 * @description : LoginModule
 */
val loginRepoModule = module {
    single {
        LoginRepository(get())
    }
}


val loginViewModelModule = module {
    viewModel {
        LoginViewModel(get())
    }
}