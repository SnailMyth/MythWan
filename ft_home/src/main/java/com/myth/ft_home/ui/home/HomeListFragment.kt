package com.myth.ft_home.ui.home

import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_home.adapter.HomeListAdapter
import com.myth.lib_base.base.AbsListFragment
import com.myth.lib_base.datasource.MutablePageKeyedDataSource
import com.myth.lib_base.model.DataBean
import com.scwang.smartrefresh.layout.api.RefreshLayout

/**
 * @author : myth_hai
 * @date : 2020/9/2 16:22
 * @description : HomeListFragment
 */
class HomeListFragment : AbsListFragment<DataBean, HomeListViewModel>() {

    override fun onCreateViewAfter() {
        super.onCreateViewAfter()
        hiddenActionBar()
    }

    override fun generateAdapter(): PagedListAdapter<DataBean, RecyclerView.ViewHolder> {
        return HomeListAdapter(requireContext()) as PagedListAdapter<DataBean, RecyclerView.ViewHolder>
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mViewModel.getDataSource()!!.invalidate()
        finishRefresh()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
//当加载更多的时候返回了空数据 需要手动接管数据加载否则paging框架将不会继续加载数据

        val currentList = mAdapter.currentList

        if (currentList == null || currentList.size <= 0) {
            return
        }

        val key = currentList.size / 20

        mViewModel.getHomeList(
            key,
            key + 1,
            object : PageKeyedDataSource.LoadCallback<Int, DataBean>() {
                override fun onResult(data: MutableList<DataBean>, adjacentPageKey: Int?) {
                    //把data转成pageList
                    val dataSource = MutablePageKeyedDataSource<DataBean>()

                    dataSource.data.addAll(currentList)
                    dataSource.data.addAll(data)

                    val pageList =
                        dataSource.buildNewPageList(mAdapter.currentList!!.config)

                    mAdapter.submitList(pageList)

                }
            })

        finishRefresh()
    }

}