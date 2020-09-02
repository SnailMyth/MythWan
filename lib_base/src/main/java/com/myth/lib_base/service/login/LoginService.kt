package com.myth.lib_base.service.login

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.template.IProvider
import com.myth.lib_base.model.User

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:26
 * @description : LoginService
 */
interface LoginService : IProvider {

    fun isLogin(): Boolean

    fun getUserInfo(): User?

    fun removeUserInfo()

    fun start(context: Context): LiveData<User>

    fun getLiveData(): LiveData<User>

}