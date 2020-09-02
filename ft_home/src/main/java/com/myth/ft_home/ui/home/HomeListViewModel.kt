package com.myth.ft_home.ui.home

import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.myth.lib_base.base.AbsListViewModel
import com.myth.lib_base.base.BaseContext
import com.myth.lib_base.model.DataBean
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.launch
import java.util.*

/**
 * @author : myth_hai
 * @date : 2020/9/2 16:22
 * @description : HomeListViewModel
 */
class HomeListViewModel(private val repository: HomeRepository) : AbsListViewModel<DataBean>() {

    override fun createDataSource(): DataSource<Int, DataBean> {

        return object : PageKeyedDataSource<Int, DataBean>() {

            override fun loadInitial(
                params: LoadInitialParams<Int>,
                callback: LoadInitialCallback<Int, DataBean>
            ) {
                getHomeList(0, callback)
            }

            override fun loadAfter(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataBean>
            ) {
                getHomeList(params.key, params.key + 1, callback)
            }

            override fun loadBefore(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataBean>
            ) {
                callback.onResult(Collections.emptyList(), null)
            }


        }
    }


    fun getHomeList(
        count: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, DataBean>
    ) {

        viewModelScope.launch {
            val homeFeed = repository.getHomeList(count)
            if (homeFeed is NetResult.Success) {
                callback.onResult(homeFeed.data.data, null, 1)
            } else if (homeFeed is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    homeFeed.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

    fun getHomeList(
        count: Int,
        key: Int,
        callback: PageKeyedDataSource.LoadCallback<Int, DataBean>
    ) {


        viewModelScope.launch {
            val homeFeed = repository.getHomeList(count)
            if (homeFeed is NetResult.Success) {
                callback.onResult(homeFeed.data.data, key)
            } else if (homeFeed is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    homeFeed.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}