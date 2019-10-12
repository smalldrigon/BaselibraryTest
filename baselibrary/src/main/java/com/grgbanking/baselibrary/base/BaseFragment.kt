package com.gdmcmc.simplecharge.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.classic.common.MultipleStatusView
import com.trello.rxlifecycle2.components.support.RxFragment

/**
 *
 *@fileName BaseFragment
 *@data on 2019/3/21  13:53
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe fragment 基类，用于被子fragment继承
 *
 **/

abstract class BaseFragment: RxFragment(){
    /**
     * 视图是否加载完成
     */
    private var isViewPrepare = false

    /**
     * 数据是否加载过
     */
    private  var hasLoadData  =false

    private var fmContainerView: View? = null

    /**
     * 多种状态切换的View
     */
    protected var mLayoutStatusView: MultipleStatusView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         fmContainerView = inflater.inflate(getLayoutId(),container,false)
        return   fmContainerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewPrepare = true
        initView()
        lazyLoadDataIfPrepared()
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)

    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser){
            lazyLoadDataIfPrepared()
        }
    }

    private fun lazyLoadDataIfPrepared(){
          if (userVisibleHint &&isViewPrepare &&!hasLoadData){
              lazyLoad()
              hasLoadData = true
          }
      }

    /**
     * 获取容器视图
     */
    fun getContainerView():View?{
        return fmContainerView
    }

    /**
     * 初始化view
     */
    abstract fun initView()

    /**
     * 设置布局文件
     */
    abstract fun getLayoutId(): Int

    open val mRetryClickListener :View.OnClickListener = View.OnClickListener {
        lazyLoad()
    }

    abstract fun lazyLoad()

    //如果已经显示过内容视图，后续遇到错误依然显示内筒视图，不做视图切换
    fun showMyMultipleStatusView(status: Int) {
        when {
            status == MultipleStatusView.STATUS_LOADING -> {
                mLayoutStatusView!!.showLoading()
            }
            status == MultipleStatusView.STATUS_CONTENT -> {
                mLayoutStatusView!!.showContent()
            }
            status == MultipleStatusView.STATUS_NO_NETWORK -> {
                mLayoutStatusView!!.showNoNetwork()
            }
            status == MultipleStatusView.STATUS_EMPTY -> {
                mLayoutStatusView!!.showEmpty()
            }
            status == MultipleStatusView.STATUS_ERROR -> {
                mLayoutStatusView!!.showError()
            }
        }

    }
}

