package com.gdmcmc.simplecharge.retrofit.interceptor

import com.google.gson.JsonObject
import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 *@fileName ErrorInterceptor
 *@data on 2019/4/19  11:35
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 网络错误拦截器
 **/
class ErrorInterceptor:Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val originalResponse = chain.proceed(request)
//       val responseBody =  originalResponse.body()
//        val source = responseBody!!.source()
//        val buffer = source.buffer()
        if (isTokenExpired(originalResponse)){
            val newToken = getNewToken()
            val newRequets  = chain.request().newBuilder()
                    .addHeader("Authorization",newToken)
                    .build()
            return chain.proceed(newRequets)
        }
        return originalResponse

    }

    /**
     * 获取新的token
     * 登录获取
     */
    private fun getNewToken(): String {
//        val retrofit=   Retrofit.Builder()
//                .baseUrl("https://xxxxx")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        retrofit2.Response<JsonObject> tokenJson = retrofit.create(CommonApi.class).ccbTestGetToken().execute();
//        headerToken = tokenJson.body().get("Token").toString();
//        return headerToken;
        return ""
    }

    /**
     *@param originalResponse
     *@return token 是否过期
     *@exception/throws [违例类型] [违例说明]
     *@see              [类、类#方法、类#成员]
     *创建时间：
     *@author  QQ:904430803
     */
    private fun isTokenExpired(originalResponse: Response): Boolean {
        if (originalResponse.code() == 401){
            return true
        }
        return false
    }

}