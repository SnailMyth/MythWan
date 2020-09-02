package com.myth.ft_home.ui.home

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myth.ft_home.model.Banner
import com.myth.lib_base.base.BaseContext
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.launch

/**
 * @author : myth_hai
 * @date : 2020/9/2 16:22
 * @description : HomeViewModel
 */
class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val bannerLiveData = MutableLiveData<List<Banner>>()

    fun getBannerLiveData(): MutableLiveData<List<Banner>> {
        return bannerLiveData
    }


    fun getBanner() {
        viewModelScope.launch {
            val banner = homeRepository.getBanner()
            if (banner is NetResult.Success) {
                bannerLiveData.postValue(banner.data)
            } else if (banner is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    banner.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


}