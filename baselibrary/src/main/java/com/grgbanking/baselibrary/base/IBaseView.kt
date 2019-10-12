 package com.grgbanking.baselibrary.base
/**
 *
 *@fileName IBaseView
 *@data on 2019/3/21  11:37
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe mvp view基类，被继承  主要控制显示和隐藏loading
 **/
interface IBaseView{
    /**
     * 显示loading
     */
    fun showLoading()

    /**
     *隐藏loading
     */
    fun dismissLoading()

    /**
     * 控制显示多状态view的显示
     */
    fun showMultiStatusView(status:Int)

    /**
     * 显示toast
     */
    fun showToast(info:String)

}