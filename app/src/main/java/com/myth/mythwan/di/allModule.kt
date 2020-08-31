package com.myth.mythwan.di

import com.google.gson.GsonBuilder
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