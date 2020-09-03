package com.myth.ft_search.ui

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.myth.ft_search.R
import com.myth.ft_search.databinding.ActivitySearchBinding
import com.myth.lib_base.base.BaseActivity
import com.myth.lib_base.utils.KeyBoardUtils

class SearchActivity : BaseActivity<SearchViewModel, ActivitySearchBinding>() {

    override fun getLayoutResId(): Int = R.layout.activity_search

    override fun initData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
        addFragment(HotKeyFragment.newInstance(), "HotKeyFragment")

        mViewBinding.search.requestFocus()
        mViewBinding.cancel.setOnClickListener {
            finish()
        }

        mViewBinding.search.setOnEditorActionListener(object : TextView.OnEditorActionListener {
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {

                    if (getInputData() == null) {
                        return true
                    }

                    //隐藏光标和软键盘
                    mViewBinding.search.clearFocus()
                    KeyBoardUtils.hideKeyboard(mViewBinding.search)

                    addFragment(
                        SearchResultFragment.newInstance(getInputData()!!),
                        "SearchResultFragment"
                    )
                    return true
                }

                return false
            }

        })
    }

    private fun addFragment(fragment: Fragment, tag: String) {
        val beginTransaction = supportFragmentManager.beginTransaction()
        beginTransaction.replace(R.id.container, fragment, tag)
        beginTransaction.commit()
    }

    private fun getInputData(): String? {
        val data = mViewBinding.search.text.toString().trim()
        if (TextUtils.isEmpty(data)) {
            Toast.makeText(this, "请输入后再查询", Toast.LENGTH_SHORT).show()
            return null
        }
        return data
    }


    fun setHotKeyInputSearch(hotKey: String) {
        mViewBinding.search.setText(hotKey)
    }

    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, SearchActivity::class.java))
        }
    }

}