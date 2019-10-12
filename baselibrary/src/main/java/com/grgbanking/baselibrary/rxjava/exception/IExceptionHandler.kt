package com.grgbanking.baselibrary.rxjava.exception

/**
 *
 *@fileName IExceptionHandler
 *@data on 2019/4/28  16:57
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 错误信息处理
 **/
interface IExceptionHandler{
    /**
     * 处理过滤错误信息
     * @param e
     * @return
     */
    fun handleException(e:Throwable):RxException
}