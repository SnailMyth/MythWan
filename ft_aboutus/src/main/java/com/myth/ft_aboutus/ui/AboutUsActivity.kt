package com.myth.ft_aboutus.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.myth.ft_aboutus.R
import com.myth.lib_base.utils.StatusBarKt
import kotlinx.android.synthetic.main.activity_about_us.*

/**
 * @author : myth_hai
 * @date : 2020/9/3 12:01
 * @description : AboutUsActivity
 */
class AboutUsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarKt.fitSystemBar(this)
        setContentView(R.layout.activity_about_us)

        mIvBack.setOnClickListener {
            finish()
        }

    }


    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, AboutUsActivity::class.java))
        }

    }
}