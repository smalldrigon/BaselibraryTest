package com.grgbanking.baselibrary.rxjava.exception

/**
 *
 *@fileName RxExceptionHandler
 *@data on 2019/4/28  17:13
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
object RxExceptionHandler {

    /**
     * 默认的错误信息处理者
     */
    private var sIExceptionHandler: IExceptionHandler? = null

    /**
     * 设置错误信息处理者
     * @param exceptionHandler
     */
    fun setExceptionHandler(  exceptionHandler: IExceptionHandler) {
        sIExceptionHandler = exceptionHandler
    }

    /**
     * 处理过滤错误信息
     * @param e
     * @return
     */
    fun handleException(e: Throwable): RxException {
        return if (sIExceptionHandler != null) {
            sIExceptionHandler!!.handleException(e)
        } else {
            RxException(e, RxException.DEFAULT_ERROR)
        }
    }
}