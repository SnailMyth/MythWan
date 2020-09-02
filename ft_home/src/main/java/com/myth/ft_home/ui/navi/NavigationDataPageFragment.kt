package com.myth.ft_home.ui.navi

import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.myth.ft_home.R
import com.myth.ft_home.adapter.NavigationTabPageAdapter
import com.myth.ft_home.databinding.NavigationDataPageBinding
import com.myth.ft_home.model.navigation.NavigationItemDetail
import com.myth.lib_base.base.BaseFragment
import com.myth.lib_base.base.BaseRecyclerViewAdapter
import com.myth.lib_base.service.webview.wrap.WebViewWarpService
import org.koin.android.ext.android.get

/**
 * Create by liwen on 2020/5/30
 */
class NavigationDataPageFragment :
    BaseFragment<NavigationDataPageViewModel, NavigationDataPageBinding>() {

    private var detailList: MutableList<NavigationItemDetail>? = null

    private val gson = get<Gson>()

    companion object {
        fun newInstance(
            articles: MutableList<NavigationItemDetail>,
            gson: Gson
        ): NavigationDataPageFragment {

            val fragment = NavigationDataPageFragment()
            val bundle = Bundle()
            bundle.putString("data", gson.toJson(articles))
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun getLayoutResId(): Int = R.layout.navigation_data_page

    override fun initData() {
        val arguments = requireArguments()
        val data = arguments.getString("data")

        detailList = gson.fromJson<MutableList<NavigationItemDetail>>(
            data,
            object : TypeToken<MutableList<NavigationItemDetail>>() {}.type
        )
    }

    override fun initView() {

        mViewBinding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
        val adapter = NavigationTabPageAdapter(requireContext())
        adapter.dataList = detailList!!
        mViewBinding.recyclerView.adapter = adapter

        adapter.setOnItemClickListener(object :
            BaseRecyclerViewAdapter.OnItemClickListener<NavigationItemDetail> {
            override fun onItemClick(item: NavigationItemDetail, position: Int) {
                WebViewWarpService.instance.start(requireContext(), item.title, item.link)
            }

        })
    }


}