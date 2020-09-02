package com.myth.ft_home.model

import com.win.ft_home.model.tree.TreeDataItem

/**
 * @author : myth_hai
 * @date : 2020/9/2 15:53
 * @description : TreeData
 */
data class TreeData(
    val children: MutableList<TreeDataItem>,
    val name: String,
    val id: Int,
    val visible: Int
)