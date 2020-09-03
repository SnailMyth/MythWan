package com.myth.ft_search.ui

import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_search.R
import com.myth.ft_search.adapter.SearchHotKeyAdapter
import com.myth.ft_search.databinding.HotkeyPageBinding
import com.myth.ft_search.model.HotKeyModel
import com.myth.lib_base.base.BaseFragment
import com.myth.lib_base.base.BaseRecyclerViewAdapter

class HotKeyFragment : BaseFragment<HotKeyViewModel, HotkeyPageBinding>() {


    private lateinit var mRecycleView: RecyclerView

    override fun getLayoutResId(): Int = R.layout.hotkey_page

    override fun initData() {
        mViewModel.getHotKey().observe(this, Observer {
            val adapter = SearchHotKeyAdapter(requireContext())
            adapter.dataList = it
            mRecycleView.adapter = adapter

            adapter.setOnItemClickListener(object :
                BaseRecyclerViewAdapter.OnItemClickListener<HotKeyModel> {
                override fun onItemClick(item: HotKeyModel, position: Int) {
                    (requireActivity() as SearchActivity).setHotKeyInputSearch(item.name)
                }
            })
        })
    }


        override fun initView() {
            mRecycleView = mViewBinding.recycleView
            mRecycleView.layoutManager =
                GridLayoutManager(requireContext(), 2)

        }


    companion object {
        fun newInstance(): HotKeyFragment {
            return HotKeyFragment()
        }
    }
}