package com.myth.ft_search.ui

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myth.ft_search.model.HotKeyModel
import com.myth.lib_base.base.BaseContext
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.launch

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:06
 * @description : HotKeyViewModel
 */
class HotKeyViewModel(private val repo: SearchRepository) : ViewModel() {

    private val hotKeyLiveData = MutableLiveData<MutableList<HotKeyModel>>()

    fun getHotKey(): MutableLiveData<MutableList<HotKeyModel>> {
        viewModelScope.launch {
            val hotKey = repo.getHotKey()
            if (hotKey is NetResult.Success) {
                hotKeyLiveData.postValue(hotKey.data)
            } else if (hotKey is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    hotKey.exception.msg,
                    Toast.LENGTH_LONG
                ).show()            }
        }
        return hotKeyLiveData
    }
}