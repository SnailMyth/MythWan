package com.myth.ft_login.ui

import com.myth.ft_login.api.RequestCenter
import com.myth.lib_base.model.User
import com.myth.lib_net.model.NetResult
import com.myth.lib_net.net.BaseRepository
import com.myth.lib_net.net.RetrofitClient



/**
 * @author : myth_hai
 * @date : 2020/9/3 10:31
 * @description : LoginRepository
 */
class LoginRepository(private val service: RetrofitClient) : BaseRepository() {

    suspend fun login(username: String, password: String): NetResult<User> {
        return callRequest(call = { requestLogin(username, password) })
    }

    suspend fun register(
        username: String,
        password: String,
        surePassword: String
    ): NetResult<User> {
        return callRequest(call = { requestRegister(username, password, surePassword) })
    }

    private suspend fun requestLogin(username: String, password: String): NetResult<User> =
        handleResponse(
            service.create(RequestCenter::class.java).login(username, password)
        )

    private suspend fun requestRegister(
        username: String,
        password: String,
        surePassword: String
    ): NetResult<User> =
        handleResponse(
            service.create(RequestCenter::class.java).register(username, password, surePassword)
        )

}