package com.grgbanking.baselibrary.rxjava

import android.view.View
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import java.time.Duration
import java.util.concurrent.TimeUnit

/**
 *
 *@fileName RxViewUtils
 *@data on 2019/5/10  9:24
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe rxview 工具类
 **/
object RxViewUtils{
    fun  clicks(v:View): Observable<Any> {
       return clicks(1000,v)
    }

    fun  clicks(duration:Long,v:View): Observable<Any> {
       return RxView.clicks(v).throttleFirst(duration,TimeUnit.MILLISECONDS)
    }
}