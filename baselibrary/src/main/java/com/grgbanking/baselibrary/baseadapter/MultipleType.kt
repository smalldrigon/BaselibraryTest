package com.grgbanking.baselibrary.baseadapter

/**
 *
 *@fileName MultipleType
 *@data on 2019/4/11  13:59
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
interface MultipleType<in T>{
    fun getLayoutId(item:T,position:Int):Int
}