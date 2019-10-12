package com.gdmcmc.wckc.rx.scheduler

import io.reactivex.*
import org.reactivestreams.Publisher

/**
 *
 *@fileName BaseScheduler
 *@data on 2018/11/20  14:26
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
abstract class BaseScheduler<T>  constructor(private val subscribeOnScheduler:Scheduler,
                                             private val observeOnScheduler: Scheduler):
        ObservableTransformer<T,T>
,

SingleTransformer<T, T>,
MaybeTransformer<T, T>,
CompletableTransformer,
FlowableTransformer<T, T> {

    override fun apply(upstream: Completable): CompletableSource {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Flowable<T>): Publisher<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Maybe<T>): MaybeSource<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Observable<T>): ObservableSource<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
    }

    override fun apply(upstream: Single<T>): SingleSource<T> {
        return upstream.subscribeOn(subscribeOnScheduler)
                .observeOn(observeOnScheduler)
    }
}