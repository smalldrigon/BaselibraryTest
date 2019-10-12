package com.grgbanking.baselibrary.extension

import android.app.Activity
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Toast

/**
 *
 *@fileName Extension
 *@data on 2019/5/27  14:19
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 扩展类
 **/
//============================ 吐司相关============================

fun Fragment.showToastLong(msg: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, msg, Toast.LENGTH_LONG)
    toast.show()
    return toast
}

fun Fragment.showToastShort(msg: String): Toast {
    val toast = Toast.makeText(this.activity?.applicationContext, msg, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}

fun Activity.showToastLong(msg: String): Toast {
    val toast = Toast.makeText(this?.applicationContext, msg, Toast.LENGTH_LONG)
    toast.show()
    return toast
}

fun Activity.showToastShort(msg: String): Toast {
    val toast = Toast.makeText(this?.applicationContext, msg, Toast.LENGTH_SHORT)
    toast.show()
    return toast
}
//============================ 吐司相关============================


















//============================ 日志相关============================
fun String.logI(tag: String) {
    var s = Throwable().getStackTrace()[1];
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.i(tag, "$str${this.toString()}")
}

fun String.logI() {
    var s = Throwable().getStackTrace()[1];
//    var str = "类:" + s.getClassName() + "文件名:" + s.getFileName() + " 方法:" + s.getMethodName() + "第" + s.getLineNumber() + "行";
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.i("gong", "$str${this.toString()}")
}

fun String.logE(tag: String) {
    var s = Throwable().getStackTrace()[1];
//    var str = "类:" + s.getClassName() + "文件名:" + s.getFileName() + " 方法:" + s.getMethodName() + "第" + s.getLineNumber() + "行";
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.e("gong", "$str${this.toString()}")
}

fun String.logD(tag: String) {
    var s = Throwable().getStackTrace()[1];
//    var str = "类:" + s.getClassName() + "文件名:" + s.getFileName() + " 方法:" + s.getMethodName() + "第" + s.getLineNumber() + "行";
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.d("gong", "$str${this.toString()}")
}

fun String.logE() {
    var s = Throwable().getStackTrace()[1];
//    var str = "类:" + s.getClassName() + "文件名:" + s.getFileName() + " 方法:" + s.getMethodName() + "第" + s.getLineNumber() + "行";
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.e("gong", "$str${this.toString()}")
}

fun String.logHttp() {
    var s = Throwable().getStackTrace()[1];
//    var str = "类:" + s.getClassName() + "文件名:" + s.getFileName() + " 方法:" + s.getMethodName() + "第" + s.getLineNumber() + "行";
    var str = s.getFileName() + "第" + s.getLineNumber() + "行"
    Log.e("gong", "$str${this.toString()}")
}
//============================ 日志相关============================