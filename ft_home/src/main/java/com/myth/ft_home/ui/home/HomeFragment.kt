package com.myth.ft_home.ui.home

import androidx.lifecycle.Observer
import com.myth.ft_home.R
import com.myth.ft_home.adapter.HomeBannerAdapter
import com.myth.ft_home.databinding.FragmentHomeBinding
import com.myth.ft_home.model.Banner
import com.myth.lib_base.base.BaseFragment

/**
 * @author : myth_hai
 * @date : 2020/9/2 16:22
 * @description : HomeFragment
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(){
    override fun getLayoutResId(): Int = R.layout.fragment_home

    override fun initData() {
        mViewModel.apply { getBanner() }

        mViewModel.getBannerLiveData()
            .observe(viewLifecycleOwner,
                Observer<List<Banner>> {
                    mViewBinding.banner.adapter = HomeBannerAdapter(it)
                })
    }

    override fun initView() {
        val supportFragmentManager = activity?.supportFragmentManager
        val beginTransaction = supportFragmentManager?.beginTransaction()
        beginTransaction?.replace(R.id.homeListContainer, HomeListFragment::class.java, null)
        beginTransaction?.commit()
    }
}
