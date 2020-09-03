package com.myth.ft_tree_detail.ui

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

class TreeDetailViewModel(private val dataRepos: TreeDetailRepository): AbsListViewModel<DataBean>() {

    private var mCid: Int = 0

    fun setCid(cid: Int) {
        mCid = cid
    }

    override fun createDataSource(): DataSource<Int, DataBean> {
        return object : PageKeyedDataSource<Int, DataBean>() {
            override fun loadInitial(
                params: LoadInitialParams<Int>,
                callback: LoadInitialCallback<Int, DataBean>
            ) {
                loadData(0, callback)
            }

            override fun loadAfter(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataBean>
            ) {
                loadData(params.key, callback)
            }

            override fun loadBefore(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, DataBean>
            ) {
                callback.onResult(Collections.emptyList(), null)
            }
        }
    }



    private fun loadData(
        key: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, DataBean>
    ) {

        viewModelScope.launch {
            val result = dataRepos.getTreeDetailList(key, mCid)
            if (result is NetResult.Success) {
                callback.onResult(result.data.data, null, 1)
            } else if (result is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    result.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    private fun loadData(
        key: Int,
        callback: PageKeyedDataSource.LoadCallback<Int, DataBean>
    ) {
        viewModelScope.launch {
            val result = dataRepos.getTreeDetailList(key, mCid)
            if (result is NetResult.Success) {
                callback.onResult(result.data.data, key + 1)
            } else if (result is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    result.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }



}