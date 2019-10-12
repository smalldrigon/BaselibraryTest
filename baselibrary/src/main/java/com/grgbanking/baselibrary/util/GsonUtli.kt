package com.grgbanking.baselibrary.util

import com.google.gson.Gson

/**
 * Author: gongxiaobiao
 * Date: on 2019/9/9 9:10
 * Email: 904430803@qq.com
 * Description: Gson工具类  将字符串转成对象
 */
object GsonUtli{
    var mGson:Gson = Gson()


    /**
     * 将gsonString转成泛型bean
     *
     * @param gsonString
     * @param cls
     * @return
     */
    fun   <T> GsonToBean(  gsonString:String, cls:Class<T> ):T {
       var t :T? =  null;
        if (mGson != null) {
            t = mGson.fromJson(gsonString, cls);
        }
        return t!!;
    }


}