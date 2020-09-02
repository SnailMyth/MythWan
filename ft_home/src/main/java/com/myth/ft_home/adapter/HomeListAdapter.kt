package com.myth.ft_home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_home.databinding.LayoutHomeListBinding
import com.myth.lib_base.model.DataBean
import com.myth.lib_base.service.webview.wrap.WebViewWarpService

class HomeListAdapter(context: Context) :

    PagedListAdapter<DataBean, HomeListAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<DataBean>() {
        override fun areContentsTheSame(
            oldItem: DataBean,
            newItem: DataBean
        ): Boolean {
            return oldItem == newItem
        }

        override fun areItemsTheSame(
            oldItem: DataBean,
            newItem: DataBean
        ): Boolean {
            return oldItem.id == newItem.id
        }
    }) {


    private val inflater = LayoutInflater.from(context)
    private val mContext = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = LayoutHomeListBinding.inflate(inflater, parent, false)

        return ViewHolder(binding.root, binding, mContext)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.setData(getItem(position)!!)

    }


    class ViewHolder(
        itemView: View,
        binding: LayoutHomeListBinding,
        context: Context
    ) : RecyclerView.ViewHolder(itemView) {

        private var mBinding = binding
        private var mContext = context

        fun setData(datasBean: DataBean) {
            mBinding.feed = datasBean

            mBinding.parentItem.setOnClickListener {
                WebViewWarpService.instance.start(mContext, datasBean.title, datasBean.link)
            }
        }
    }
}

