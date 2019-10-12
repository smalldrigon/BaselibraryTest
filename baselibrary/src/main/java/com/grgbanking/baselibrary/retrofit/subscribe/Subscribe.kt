package com.gdmcmc.simplecharge.retrofit.subscribe

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers

/**
 *
 *@fileName Subscribe
 *@data on 2019/4/19  17:31
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
    fun <T>Observable<T>.commitWithError(onNext:(T) -> Unit,onError:(Throwable) ->Unit)=
    observeOn(AndroidSchedulers.mainThread())
            .subscribe(onNext,{
                onError(it)
                it.printStackTrace()
            })

    fun <T>Observable<T>.commit(onNext:(T) -> Unit)=
            observeOn(AndroidSchedulers.mainThread())
                    .subscribe(onNext,{
                        it.printStackTrace()
                    })

