package com.myth.lib_base.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

/**
 * @author : myth_hai
 * @date : 2020/9/2 11:21
 * @description : KeyBoardUtils
 */
object KeyBoardUtils {
    fun showKeyboard(view: View) {
        val imm = view.context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        view.requestFocus()
        imm.showSoftInput(view, 0)
    }

    fun hideKeyboard(view: View) {
        val imm = view.context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun toggleSoftInput(view: View) {
        val imm = view.context
            .getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, 0)
    }
}