package com.grgbanking.baselibrary.animutils

import android.view.animation.CycleInterpolator
import android.view.animation.Animation
import android.view.animation.RotateAnimation



/**
 * Author: gongxiaobiao
 * Date: on 2019/8/19 11:20
 * Email: 904430803@qq.com
 * Description:  动画工具类
 */
object AnimUtils{
    /**
     * 晃动动画
     * 那么CycleInterpolator是干嘛用的？？
     * Api demo里有它的用法，是个摇头效果！
     *
     * @param counts 1秒钟晃动多少下
     * @return Animation
     */
    fun shakeAnimation(counts: Int): Animation {
        val rotateAnimation =
            RotateAnimation(0f, 20f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        rotateAnimation.interpolator = CycleInterpolator(counts.toFloat())
        rotateAnimation.repeatCount = 0
        rotateAnimation.duration = 500
        return rotateAnimation
    }
}