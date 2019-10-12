package com.gdmcmc.wckc.rx.scheduler

/**
 *
 *@fileName SchedulerUtils
 *@data on 2018/11/20  14:24
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
object SchedulerUtils{
    fun <T> ioToMain():IoMainScheduler<T>{
        return IoMainScheduler()
    }
}