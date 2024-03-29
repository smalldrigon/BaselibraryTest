package com.gdmcmc.simplecharge.retrofit.exception

/**
 *
 *@fileName ErrorStatus
 *@data on 2019/4/22  8:51
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 错误码
 **/
object ErrorStatus{
    /**
     * 响应成功
     */
    val SUCCESS = 0

    /**
     * 未知错误
     *
     */
 val UNKNOW_ERROR = 1002

    /**
     * 服务器内部错误
     */

    val SERVER_ERROR = 1003

    /**
     * 网络连接超时
     */

    val NETWORK_ERROR = 1004

    /**
     * API解析异常（或者第三方数据结构更改）等其他异常
     */
    val API_ERROR = 1005

}
