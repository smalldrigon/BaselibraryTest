 package com.grgbanking.baselibrary.base

 /**
 *
 *@fileName IPresenter
 *@data on 2019/3/21  11:44
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
interface IPresenter<in V: IBaseView>{

    fun attachView(mRootView:V)

    fun detachView()
}