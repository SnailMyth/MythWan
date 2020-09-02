package com.myth.ft_home.interfaces

import com.myth.ft_home.model.navigation.NavigationItem

/**
 * @author : myth_hai
 * @date : 2020/9/2 17:52
 * @description : NavigationTabItemSelectedListener
 */
interface NavigationTabItemSelectedListener {
    fun onItemSelected(item: NavigationItem, position: Int)
}