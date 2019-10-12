package com.grgbanking.baselibrary.baseadapter

/**
 *
 *@fileName OnItemClickListener
 *@data on 2019/4/11  14:01
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe adapter 条目点击事件回调
 **/
interface OnItemLongClickListener{
    fun onItemLongClick(obj: Any?, position: Int): Boolean
}