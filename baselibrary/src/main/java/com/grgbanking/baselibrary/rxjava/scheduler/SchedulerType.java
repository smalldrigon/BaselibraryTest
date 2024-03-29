package com.grgbanking.baselibrary.rxjava.scheduler;

/**
 * 线程类型
 *
 * @author xuexiang
 * @since 2018/6/12 下午11:29
 */
public enum SchedulerType {

    /**
     * 订阅发生在主线程 （  ->  -> main)
     */
    _main,
    /**
     * 订阅发生在io线程 （  ->  -> io)
     */
    _io,
    /**
     * 处理在io线程，订阅发生在主线程（ -> io -> main)
     */
    _io_main,
    /**
     * 处理在io线程，订阅也发生在io线程（ -> io -> io)
     */
    _io_io,
}
