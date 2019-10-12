package com.grgbanking.baselibrary.rxjava.subscriber

import com.grgbanking.baselibrary.extension.logE
import com.grgbanking.baselibrary.extension.logI
import com.grgbanking.baselibrary.rxjava.exception.RxException
import com.grgbanking.baselibrary.rxjava.exception.RxExceptionHandler
 import io.reactivex.functions.Consumer
import io.reactivex.subscribers.ResourceSubscriber


/**
 *
 *@fileName BaseSubscriber
 *@data on 2019/4/28  16:51
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/


 abstract  class BaseSubscriber<T> : Consumer<T>, ResourceSubscriber<T>() {
    override fun onComplete() {
        "-->Subscriber is Complete".logI()
    }

       fun onCompleted() {
         ("-->Subscriber is Complete").logE()
    }

    override fun onStart() {

       ("-->Subscriber is Start").logE()
    }

    override fun onError(e: Throwable) {
         ("-->Subscriber is onError").logE()
        try {
            if (e is RxException) {
                ("--> e instanceof RxException, message:" + e.message).logE()
                onError(e)
            } else {
                ("e !instanceof RxException, message:" + e.message).logE()
                onError(RxExceptionHandler.handleException(e))
            }
        } catch (throwable: Throwable) {  //防止onError中执行又报错导致rx.exceptions.OnErrorFailedException: Error occurred when trying to propagate error to Observer.onError问题
            e.printStackTrace()
        }

    }

    /**
     * 出错
     * @param e
     */
    abstract fun onError(e: RxException)

}
