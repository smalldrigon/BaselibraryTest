package com.grgbanking.baselibrary.retrofit.convertadapter;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * @author xiaobiaogong
 * @fileName da
 * @data on 2019/4/19  15:01
 * @email 904430803@qq.con
 * @describe TODO
 **/
public class MyGsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final Type type;

    MyGsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
//        apiHandle = new ApiHandle();
    }


    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        try {
            return gson.fromJson(response, type);
        } finally {
            value.close();
        }
    }
}