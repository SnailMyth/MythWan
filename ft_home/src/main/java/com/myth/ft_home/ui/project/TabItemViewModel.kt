package com.myth.ft_home.ui.project

import android.widget.Toast
import androidx.lifecycle.viewModelScope
import androidx.paging.DataSource
import androidx.paging.PageKeyedDataSource
import com.myth.ft_home.model.ProjectItemSub
import com.myth.lib_base.base.AbsListViewModel
import com.myth.lib_base.base.BaseContext
import com.myth.lib_net.model.NetResult
import kotlinx.coroutines.launch
import java.util.*

class TabItemViewModel(private val repository: ProjectRepository) :
    AbsListViewModel<ProjectItemSub>() {
    private var mId: Int = 0

    fun setId(id: Int) {
        mId = id
    }


    override fun createDataSource(): DataSource<Int, ProjectItemSub> {

        return object : PageKeyedDataSource<Int, ProjectItemSub>() {
            override fun loadInitial(
                params: LoadInitialParams<Int>,
                callback: LoadInitialCallback<Int, ProjectItemSub>
            ) {
                getTabPageData(1, callback)
            }

            override fun loadAfter(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, ProjectItemSub>
            ) {
                getTabPageData(params.key, callback)
            }

            override fun loadBefore(
                params: LoadParams<Int>,
                callback: LoadCallback<Int, ProjectItemSub>
            ) {
                callback.onResult(Collections.emptyList(), null)
            }

        }
    }

    fun getTabPageData(
        count: Int,
        callback: PageKeyedDataSource.LoadCallback<Int, ProjectItemSub>
    ) {
        viewModelScope.launch {
            val data = repository.getTabItemPageData(count, mId)
            if (data is NetResult.Success) {
                callback.onResult(data.data.data, count + 1)
            } else if (data is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    data.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }


    fun getTabPageData(
        count: Int,
        callback: PageKeyedDataSource.LoadInitialCallback<Int, ProjectItemSub>
    ) {
        viewModelScope.launch {
            val data = repository.getTabItemPageData(count, mId)
            if (data is NetResult.Success) {
                callback.onResult(data.data.data, 0, 2)
            } else if (data is NetResult.Error) {
                Toast.makeText(
                    BaseContext.instance.getContext(),
                    data.exception.msg,
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

}