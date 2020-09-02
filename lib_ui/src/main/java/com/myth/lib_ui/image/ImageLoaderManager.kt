package com.myth.lib_ui.image

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.myth.lib_ui.R

class ImageLoaderManager private constructor() {

    private object SingletonHolder {
        val holder = ImageLoaderManager()
    }

    companion object {
        val instance: ImageLoaderManager = SingletonHolder.holder
    }


    /**
     * 带回调的加载图片方法
     *
     * @param imageView
     * @param url
     * @param requestListener
     */
    @JvmOverloads
    fun displayImageForView(
        imageView: ImageView, url: String?,
        requestListener: CustomRequestListener? = null
    ) {
        Glide.with(imageView.context)
            .asBitmap()
            .load(url)
            .apply(initCommonRequestOption())
//                            .transition(withCrossFade())
            .into(imageView)
    }

    /**
     * 带回调的加载圆形图片方法
     *
     * @param imageView
     * @param url
     */
    fun displayImageForCircle(
        imageView: ImageView,
        url: String?
    ) {
        Glide.with(imageView.context)
            .asBitmap()
            .load(url)
            .apply(initCommonRequestOption())
            .into(object : BitmapImageViewTarget(imageView) {
                override fun setResource(resource: Bitmap?) {
                    val circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(
                            imageView.resources,
                            resource
                        )
                    circularBitmapDrawable.isCircular = true
                    imageView.setImageDrawable(circularBitmapDrawable)
                }
            })
    }

    @SuppressLint("CheckResult")
    private fun initCommonRequestOption(): RequestOptions {
        val options = RequestOptions()
        options.placeholder(R.drawable.place_holder)
            .error(R.drawable.place_holder)
            .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
            .skipMemoryCache(false)
            .priority(Priority.NORMAL)
        return options
    }

}
