/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.grgbanking.baselibrary.rxjava.rxbus;

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import java.util.concurrent.ConcurrentHashMap;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * RxBus事件通知工具
 *
 * @author xuexiang
 * @since 2018/3/1 上午10:30
 */
//public class RxBus {
//
//    /**
//     * 事件订阅的注册池， Key：事件名， value：事件的订阅者（事件的消费者、目标）
//     */
//    private ConcurrentHashMap<Object, List<Subject>> maps = new ConcurrentHashMap<>();
//
//    private static RxBus sInstance;
//
//    /**
//     * 获取RxBus的实例
//     *
//     * @return
//     */
//    public static RxBus get() {
//        if (sInstance == null) {
//            synchronized (RxBus.class) {
//                if (sInstance == null) {
//                    sInstance = new RxBus();
//                }
//            }
//        }
//        return sInstance;
//    }
//
//
//    /**
//     * 注册事件的订阅
//     *
//     * @param eventName 事件名
//     * @param <T>
//     * @return 订阅者
//     */
//    public <T> Flowable<T> register(@NonNull Object eventName, Class<T> clazz) {
//        return register(eventName).toFlowable(BackpressureStrategy.LATEST).ofType(clazz);
//    }
//
//    /**
//     * 注册事件的订阅
//     *
//     * @param eventName 事件名
//     * @return 订阅者
//     */
//    private  <T> Subject<T> register(@NonNull Object eventName) {
//        List<Subject> subjects = maps.get(eventName);
//        if (subjects == null) {
//            subjects = new ArrayList<>();
//            maps.put(eventName, subjects);
//        }
//        Subject<T> subject = PublishSubject.<T>create().toSerialized();
//        subjects.add(subject);
//        return subject;
//    }
//
//    /**
//     * 注销事件指定的订阅者
//     *
//     * @param eventName 事件名
//     * @param flowable  需要取消的订阅者
//     */
//    public void unregister(@NonNull Object eventName, @NonNull Flowable flowable) {
//        List<Subject> subjects = maps.get(eventName);
//        if (subjects != null) {
//            subjects.remove(flowable);
//            if (subjects.isEmpty()) {
//                maps.remove(eventName);
//            }
//        }
//    }
//
//    /**
//     * 注销事件所有的订阅（注销事件）
//     *
//     * @param eventName 事件名
//     */
//    public void unregisterAll(@NonNull Object eventName) {
//        List<Subject> subjects = maps.get(eventName);
//        if (subjects != null) {
//            maps.remove(eventName);
//        }
//    }
//
//    /**
//     * 发送指定的事件(不携带数据)
//     *
//     * @param eventName 事件名
//     */
//    public void post(@NonNull Object eventName) {
//        post(eventName, eventName);
//    }
//
//    /**
//     * 发送指定的事件（携带数据）
//     *
//     * @param eventName 注册标识
//     * @param content   发送的内容
//     */
//    public void post(@NonNull Object eventName, @NonNull Object content) {
//        List<Subject> subjects = maps.get(eventName);
//        if (subjects != null && !subjects.isEmpty()) {
//            for (Subject s : subjects) {
//                s.onNext(content);
//            }
//        }
//    }
//}
class RxBus {

    private val mBus: Subject<Any>

    private val mStickyEventMap: MutableMap<Class<*>, Any>

    init{
        mBus = PublishSubject.create<Any>().toSerialized()
        mStickyEventMap = ConcurrentHashMap()
    }

    /**
     * 发送事件
     */
    fun post(event: Any) {
        mBus.onNext(event)
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    fun <T> toObservable(eventType: Class<T>): Observable<T> {
        return mBus.ofType(eventType)
    }

    /**
     * 判断是否有订阅者
     */
    fun hasObservers(): Boolean {
        return mBus.hasObservers()
    }

    fun reset() {
        mDefaultInstance = null
    }

    /**
     * Stciky 相关
     */

    /**
     * 发送一个新Sticky事件
     */
    fun postSticky(event: Any) {
        synchronized(mStickyEventMap) {
            mStickyEventMap.put(event.javaClass, event)
        }
        post(event)
    }

    /**
     * 根据传递的 eventType 类型返回特定类型(eventType)的 被观察者
     */
    fun <T> toObservableSticky(eventType: Class<T>): Observable<T> {
        synchronized(mStickyEventMap) {
            val observable = mBus.ofType(eventType)
            val event = mStickyEventMap[eventType]

            return if (event != null) {
                observable.mergeWith(Observable.create { subscriber -> subscriber.onNext(eventType.cast(event)) })
            } else {
                observable
            }
        }
    }

    /**
     * 根据eventType获取Sticky事件
     */
    fun <T> getStickyEvent(eventType: Class<T>): T {
        synchronized(mStickyEventMap) {
            return eventType.cast(mStickyEventMap[eventType])
        }
    }

    /**
     * 移除指定eventType的Sticky事件
     */
    fun <T> removeStickyEvent(eventType: Class<T>): T {
        synchronized(mStickyEventMap) {
            return eventType.cast(mStickyEventMap.remove(eventType))
        }
    }

    /**
     * 移除所有的Sticky事件
     */
    fun removeAllStickyEvents() {
        synchronized(mStickyEventMap) {
            mStickyEventMap.clear()
        }
    }

    companion object {
        @Volatile
        private var mDefaultInstance: RxBus? = null

        val instance: RxBus?
                get() {
            if (mDefaultInstance == null) {
                synchronized(RxBus::class.java) {
                    if (mDefaultInstance == null) {
                        mDefaultInstance = RxBus()
                    }
                }
            }
            return mDefaultInstance
        }


        /**
         * 普通订阅解绑
         * @param disposable
         */
        fun rxBusUnbund(disposable: CompositeDisposable?) {
            if (null != disposable && !disposable.isDisposed) {
                disposable.clear()
            }
        }
    }
}