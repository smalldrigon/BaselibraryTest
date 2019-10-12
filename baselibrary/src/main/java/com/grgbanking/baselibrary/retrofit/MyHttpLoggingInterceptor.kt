package com.gdmcmc.simplecharge.retrofit

import android.util.Log
import okhttp3.FormBody
import okhttp3.Interceptor
import okhttp3.Response
import okhttp3.ResponseBody


class MyHttpLoggingInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

    val startTime = System.currentTimeMillis()
        val request = chain.request()
        val response = chain.proceed(request)
        val requesthead = request.headers()
        val endTime = System.currentTimeMillis()
        val duration = endTime - startTime
        val mediaType = response.body()!!.contentType()
        val content = response.body()!!.string()
        val TAG = "http"
        Log.d(TAG, "\n")
        Log.d(TAG, "----------Start----------------")
        Log.d(TAG, "| " + request.toString())
        val method = request.method()
        if ("POST" == method) {
            val sb = StringBuilder()
            if (request.body() is FormBody) {
                val body = request.body() as FormBody
                for (i in 0 until body.size()) {
                    sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",")
                }
                sb.delete(sb.length - 1, sb.length)
                Log.d(TAG, "| RequestParams:{" + sb.toString() + "}")
            }
        }

        Log.d(TAG, "| Response:" + content);
        Log.d(TAG,"----------End:"+duration+"毫秒----------");
//        val requestbody = request.body()
//
//        val respbody = response.body()
//        val res = "head${requesthead.toString()},\n,body${requestbody.toString()},\n response${respbody.toString()}"
//        res.logHttp()
        return  response.newBuilder().body(ResponseBody.create(mediaType,content)).build()
    }

}
