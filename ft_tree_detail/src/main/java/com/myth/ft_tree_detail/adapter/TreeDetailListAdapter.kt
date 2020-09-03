package com.myth.ft_tree_detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_tree_detail.R
import com.myth.ft_tree_detail.databinding.TreeDetailListItemBinding
import com.myth.lib_base.model.DataBean
import com.myth.lib_base.service.webview.wrap.WebViewWarpService

/**
 * @author : myth_hai
 * @date : 2020/9/3 11:54
 * @description : TreeDetailListAdapter
 */
class TreeDetailListAdapter(context: Context) :
    PagedListAdapter<DataBean, TreeDetailListAdapter.ViewHolder>(
        object : DiffUtil.ItemCallback<DataBean>() {
            override fun areItemsTheSame(
                oldItem: DataBean,
                newItem: DataBean
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: DataBean,
                newItem: DataBean
            ): Boolean {
                return oldItem.id == newItem.id
            }
        }

    ) {

    private val mContext = context
    private val inflater = LayoutInflater.from(mContext)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<TreeDetailListItemBinding>(
            inflater,
            R.layout.tree_detail_list_item,
            parent,
            false
        )
        return ViewHolder(binding.root, binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(getItem(position)!!)
    }

    inner class ViewHolder(
        itemView: View,
        binding: TreeDetailListItemBinding
    ) : RecyclerView.ViewHolder(itemView) {

        private val mBinding = binding

        fun setData(item: DataBean) {
            mBinding.item = item

            mBinding.itemParent.setOnClickListener {
                WebViewWarpService.instance.start(mContext, item.title, item.link)
            }

        }

    }
}