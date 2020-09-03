package com.myth.ft_login.ui

import androidx.lifecycle.Observer
import com.myth.ft_login.R
import com.myth.ft_login.UserManager
import com.myth.ft_login.databinding.ActivityLoginBinding
import com.myth.ft_login.model.LoginLayoutBean
import com.myth.lib_base.base.BaseActivity
import com.myth.lib_base.model.User

class LoginActivity: BaseActivity<LoginViewModel, ActivityLoginBinding>(){

    private lateinit var mData: LoginLayoutBean

    override fun getLayoutResId(): Int = R.layout.activity_login

    override fun initData() {
        mData = LoginLayoutBean()
        mViewBinding.bean = mData
    }

    override fun initView() {
        mViewBinding.close.setOnClickListener {
            finish()
        }

        mViewBinding.featureName.setOnClickListener {
            mData.isLogin = !mData.isLogin
            initEditText()
        }

        mViewBinding.btnLogin.setOnClickListener {

            if (mData.isLogin) { //登录
                loginAction()
            } else { //注册
                registerAction()
            }
        }
    }

    private fun loginAction() {
        mViewModel.login(getUserName(), getPassword()).observe(this, Observer { user ->
            saveUserInfo(user)
        })
    }


    private fun initEditText() {
        mViewBinding.userName.text = null
        mViewBinding.password.text = null
        mViewBinding.surePassword.text = null
    }

    private fun getSurePassword(): String {
        return mViewBinding.surePassword.text.toString().trim()
    }

    private fun getUserName(): String {
        return mViewBinding.userName.text.toString().trim()
    }


    private fun getPassword(): String {
        return mViewBinding.password.text.toString().trim()
    }

    private fun registerAction() {
        mViewModel.register(getUserName(), getPassword(), getSurePassword())
            .observe(this, Observer { user ->
                saveUserInfo(user)
            })
    }

    private fun saveUserInfo(user: User?) {
        UserManager.saveUser(user)
        finish()
    }

}
