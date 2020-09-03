package com.myth.ft_search.ui

import android.os.Bundle
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_search.adapter.SearchResultAdapter
import com.myth.lib_base.base.AbsListFragment
import com.myth.lib_base.datasource.MutablePageKeyedDataSource
import com.myth.lib_base.model.DataBean
import com.scwang.smartrefresh.layout.api.RefreshLayout

class SearchResultFragment : AbsListFragment<DataBean, SearchResultViewModel>() {

    private lateinit var mPagedListAdapter: PagedListAdapter<DataBean, RecyclerView.ViewHolder>

    override fun onCreateViewAfter() {
        super.onCreateViewAfter()

        hiddenActionBar()

        val hotKey = requireArguments().getString("hotkey")
        mViewModel.setHotKey(hotKey!!)

    }

    override fun generateAdapter(): PagedListAdapter<DataBean, RecyclerView.ViewHolder> {
        mPagedListAdapter =
            SearchResultAdapter(requireContext()) as PagedListAdapter<DataBean, RecyclerView.ViewHolder>
        return mPagedListAdapter
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mViewModel.getDataSource()!!.invalidate()
        finishRefresh()
    }

    override fun onLoadMore(refreshLayout: RefreshLayout) {
        val currentList = mPagedListAdapter.currentList

        if (currentList == null || currentList.size <= 0) {
            return
        }

        val count = currentList.size / 20

        mViewModel.loadDataAfter(
            count,
            object : PageKeyedDataSource.LoadCallback<Int, DataBean>() {
                override fun onResult(data: MutableList<DataBean>, adjacentPageKey: Int?) {

                    val dataSource = MutablePageKeyedDataSource<DataBean>()

                    dataSource.data.addAll(currentList)
                    dataSource.data.addAll(data)

                    val buildNewPageList = dataSource.buildNewPageList(currentList.config)

                    mPagedListAdapter.submitList(buildNewPageList)
                }

            })
        finishRefresh()
    }

    companion object {
        fun newInstance(hotKey: String): SearchResultFragment {
            val fragment = SearchResultFragment()
            val bundle = Bundle()
            bundle.putString("hotkey", hotKey)
            fragment.arguments = bundle
            return fragment
        }
    }

}