package com.myth.ft_home.adapter

import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.myth.ft_home.model.Banner
import com.myth.lib_ui.image.ImageLoaderManager
import com.youth.banner.adapter.BannerAdapter


class HomeBannerAdapter(mDatas:List<Banner>)
    : BannerAdapter<Banner, HomeBannerAdapter.BannerViewHolder>(mDatas){


    //创建ViewHolder，可以用viewType这个字段来区分不同的ViewHolder
    override fun onCreateHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val imageView = ImageView(parent.context)
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        return BannerViewHolder(imageView)
    }

    override fun onBindView(holder: BannerViewHolder, data: Banner, position: Int, size: Int) {
        ImageLoaderManager.instance.displayImageForView(holder.imageView, data.imagePath)
    }

    inner class BannerViewHolder(var imageView: ImageView) :
        RecyclerView.ViewHolder(imageView)
}