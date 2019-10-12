package com.grgbanking.baselibrary.rxjava.exception

import android.util.Log


//class RxException(message: String?): Exception(message) {
//    /**
//     * 默认错误码
//     */
//    val DEFAULT_ERROR = -1
//
//    /**
//     * 自定义的错误码
//     */
//    private var mCode: Int = 0
//
//    constructor(message: String, code: Int):super(message) {
//        mCode = code
//    }
//
//    constructor(e: Throwable, code: Int):super(e)  {
//
//        mCode = code
//    }
//
//    /**
//     * 获取自定义的错误码
//     *
//     * @return
//     */
//    fun getCode(): Int {
//        return mCode
//    }
//
//    fun getMessage(): String {
//        return "Code:" + mCode + ", Message:" + getDetailMessage()
//    }
//
//    /**
//     * 获取详情信息
//     *
//     * @return
//     */
//    fun getDetailMessage(): String {
//        return this.getMessage()
//    }
//
//    /**
//     * 获取错误堆栈信息
//     *
//     * @return
//     */
//    fun getExceptionStackTraceInfo(): String {
//          Log.getStackTraceString(this).logE()
//        return  Log.getStackTraceString(this)
//    }
//}
//class RxException : Exception {
//
//    /**
//     * 自定义的错误码
//     */
//    /**
//     * 获取自定义的错误码
//     *
//     * @return
//     */
//    var code: Int = 0
//        private set
//
//    /**
//     * 获取详情信息
//     *
//     * @return
//     */
//    val detailMessage: String?
//        get() = super.message
//
//    /**
//     * 获取错误堆栈信息
//     *
//     * @return
//     */
//    val exceptionStackTraceInfo: String
//        get() = Log.getStackTraceString(this)
//
//    constructor(message: String, code: Int) : super(message) {
//        this.code = code
//    }
//
//    constructor(e: Throwable, code: Int) : super(e) {
//        this.code = code
//    }
//
//      fun getMessages():String {
//        return "Code:$code, Message:$detailMessage"
//    }
//
//    companion object {
//        /**
//         * 默认错误码
//         */
//        val DEFAULT_ERROR = -1
//    }
//}

/**
 * 自定义错误
 *
 * @author xuexiang
 * @since 2018/6/10 下午9:29
 */
class RxException : Exception {

    /**
     * 自定义的错误码
     */
    /**
     * 获取自定义的错误码
     *
     * @return
     */
    var code: Int = 0
        private set

    /**
     * 获取详情信息
     *
     * @return
     */
    val detailMessage: String?
        get() = super.message

    /**
     * 获取错误堆栈信息
     *
     * @return
     */
    val exceptionStackTraceInfo: String
        get() = Log.getStackTraceString(this)

    constructor(message: String, code: Int) : super(message) {
        this.code = code
    }

    constructor(e: Throwable, code: Int) : super(e) {
        this.code = code
    }

    fun getMessages(): String {
        return "Code:$code, Message:$detailMessage"
    }

    companion object {
        /**
         * 默认错误码
         */
        val DEFAULT_ERROR = -1
    }
}
