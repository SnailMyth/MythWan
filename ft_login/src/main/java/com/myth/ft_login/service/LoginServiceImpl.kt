package com.myth.ft_login.service

import android.content.Context
import androidx.lifecycle.LiveData
import com.alibaba.android.arouter.facade.annotation.Route
import com.myth.ft_login.UserManager
import com.myth.lib_base.model.User
import com.myth.lib_base.service.ConstantsPath
import com.myth.lib_base.service.login.LoginService


/**
 * @author : myth_hai
 * @date : 2020/9/3 10:35
 * @description : LoginServiceImpl
 */
@Route(path = ConstantsPath.LOGIN_SERVICE_PATH)
class LoginServiceImpl : LoginService {

    override fun isLogin(): Boolean {
        return UserManager.isLogin()
    }

    override fun getUserInfo(): User? {
        return UserManager.getUser()
    }

    override fun removeUserInfo() {
        UserManager.removeUser()
    }

    override fun start(context: Context): LiveData<User> {
        return UserManager.start(context)
    }

    override fun getLiveData(): LiveData<User> {
        return UserManager.getLoginLiveData()
    }

    override fun init(context: Context?) {

    }
}