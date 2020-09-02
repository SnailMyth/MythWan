package com.myth.lib_base.utils

import android.text.TextUtils
import com.myth.lib_base.model.DataBean

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:21
 * @description : ConvertUtils
 */
object ConvertUtils {

    @JvmStatic
    fun convertName(feed: DataBean): String {

        return if (TextUtils.isEmpty(feed.author)) {
            "推荐者：${feed.shareUser}"
        } else {
            "作者：${feed.author}"
        }

    }

}