package com.myth.ft_home.ui.project

import android.os.Bundle
import androidx.paging.PageKeyedDataSource
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_home.adapter.ProjectPageAdapter
import com.myth.ft_home.model.ProjectItemSub
import com.myth.lib_base.base.AbsListFragment
import com.myth.lib_base.datasource.MutablePageKeyedDataSource
import com.scwang.smartrefresh.layout.api.RefreshLayout

class TabItemFragment : AbsListFragment<ProjectItemSub, TabItemViewModel>() {

    companion object {
        fun newInstance(id: Int): TabItemFragment {
            val args = Bundle()
            args.putInt("id", id)
            val fragment = TabItemFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateViewAfter() {
        super.onCreateViewAfter()
        hiddenActionBar()
        val arguments = requireArguments()
        val id = arguments.getInt("id")
        mViewModel.setId(id)
    }

    override fun generateAdapter(): PagedListAdapter<ProjectItemSub, RecyclerView.ViewHolder> {
        return ProjectPageAdapter(requireContext()) as PagedListAdapter<ProjectItemSub, RecyclerView.ViewHolder>
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        mViewModel.getDataSource()!!.invalidate()
        finishRefresh()
    }



    override fun onLoadMore(refreshLayout: RefreshLayout) {

        val currentList = mAdapter.currentList
        if (currentList == null || currentList.size <= 0) {
            return
        }

        val config = currentList!!.config

        val count = currentList.size / 15

        mViewModel.getTabPageData(count,
            object : PageKeyedDataSource.LoadCallback<Int, ProjectItemSub>() {
                override fun onResult(data: MutableList<ProjectItemSub>, adjacentPageKey: Int?) {

                    val dataSource = MutablePageKeyedDataSource<ProjectItemSub>()

                    dataSource.data.addAll(currentList)
                    dataSource.data.addAll(data)

                    val pageList = dataSource.buildNewPageList(config)

                    mAdapter.submitList(pageList)

                }

            })

        finishRefresh()

    }

}