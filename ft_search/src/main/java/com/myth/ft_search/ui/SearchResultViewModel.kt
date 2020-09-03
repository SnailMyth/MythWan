package com.myth.ft_search.ui

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
 * @date : 2020/9/3 11:07
 * @description : SearchResultViewModel
 */
class SearchResultViewModel(private val repo: SearchRepository) :
    AbsListViewModel<DataBean>() {

    private var mHotKey: String = ""

    fun setHotKey(hotKey: String) {
        mHotKey = hotKey
    }

    private fun getHotKey(): String {
        return mHotKey
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
                loadDataAfter(params.key, callback)
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
        page: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, DataBean>
    ) {

        viewModelScope.launch {
            val search = repo.search(page, getHotKey())
            if (search is NetResult.Success) {
                callback.onResult(search.data.data, null, 1)
            } else if (search is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    search.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    fun loadDataAfter(
        key: Int,
        callback: PageKeyedDataSource.LoadCallback<Int, DataBean>
    ) {

        viewModelScope.launch {

            val search = repo.search(key, getHotKey())
            if (search is NetResult.Success) {
                callback.onResult(search.data.data, key + 1)
            } else if (search is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    search.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}