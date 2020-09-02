package com.myth.ft_home.model.navigation

/**
 * @author : myth_hai
 * @date : 2020/9/2 15:54
 * @description : NavigationItem
 */
data class NavigationItem(
    val cid: Int,
    val name: String,
    var isSelected: Boolean,
    val articles: MutableList<NavigationItemDetail>
)