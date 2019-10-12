package com.gdmcmc.simplecharge.retrofit.exception

 import com.google.gson.JsonParseException
 import com.grgbanking.baselibrary.extension.logE
 import okhttp3.internal.http2.ErrorCode
import org.json.JSONException
import java.lang.IllegalArgumentException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.text.ParseException

/**
 *
 *@fileName ExceptionHandle
 *@data on 2019/4/22  8:49
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 异常处理类 服务器异常，网络异常，数据解析异常等
 **/
class ExceptionHandle{
    companion object {
        var errorCode = ErrorStatus.UNKNOW_ERROR
        var errorMsg = "请求失败,请稍候再试"

        fun handleException(e:Throwable):String{
            e.printStackTrace()
            if (e is SocketTimeoutException)
            {
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR
            }else if(e is ConnectException)
            {
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR
            } else if(e is JsonParseException||e is JSONException || e is ParseException)
            {
                errorMsg = "数据解析异常"
                errorCode = ErrorStatus.SERVER_ERROR
            } else if(e is UnknownHostException){
                errorMsg = "网络连接异常"
                errorCode = ErrorStatus.NETWORK_ERROR

            } else if(e is IllegalArgumentException){
            errorMsg = "参数错误"
            errorCode = ErrorStatus.SERVER_ERROR

            } else{//未知错误
                try {
                    "错误${e.message}".logE()
                }catch (e1:Exception){
                    "未知的错误，没有判断的类型".logE()
                }
                errorMsg = "未知的错误，没有判断的类型"
                errorCode = ErrorStatus.SERVER_ERROR
            }

            return errorMsg
        }


    }
}