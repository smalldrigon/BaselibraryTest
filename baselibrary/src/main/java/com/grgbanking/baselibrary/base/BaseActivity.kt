package com.gdmcmc.simplecharge.base

//import android.support.v7.app.AppCompatActivity
import android.os.Build
import android.os.Bundle
import android.view.View
import com.classic.common.MultipleStatusView
import com.grgbanking.baselibrary.util.ActivityUtil
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity


/**
 *
 *@fileName BaseActivity
 *@data on 2019/3/20  16:43
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 基本库  Activity基类，被继承
 **/
abstract class BaseActivity  : RxAppCompatActivity(){
//        AppCompatActivity(){
    /**
     * 多种状态切换的view
     */
    protected var mLayoutStatusView: MultipleStatusView? = null



    var mSavedInstanceState:Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ActivityUtil.getInstance().addActivity(this)
        mSavedInstanceState = savedInstanceState
//无title
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        全屏
//        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
//                WindowManager.LayoutParams. FLAG_FULLSCREEN);
//        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)

        setContentView(layoutId())
//        goneKey()
        initData()
        initView()
        addErrorListener()

    }

    override fun onResume() {
        super.onResume()
        goneKey()
    }

    fun goneKey() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            val decorView = window.decorView
            decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }
    }

//    override fun onWindowFocusChanged(hasFocus: Boolean) {
//        super.onWindowFocusChanged(hasFocus)
//        if (hasFocus) {
//            window.decorView.systemUiVisibility =
//                (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                        or View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//        }
//    }

    private val mRetryClickListener: View.OnClickListener = View.OnClickListener {
        start()
    }

    /**
     * 添加页面加载错误（比如网络故障等）点击重新加载的监听
     */
    private fun addErrorListener(){
        mLayoutStatusView?.setOnClickListener(mRetryClickListener)
    }



    /**
     * 抽象方法，在子Activity设置布局文件
     * eg: return R.layout.simplelayout
     */
      abstract fun layoutId():Int

    /**
     * 初始化数据
     */
    abstract fun initData()

    /**
     * 初始化view
     */
    abstract fun initView()

    /**
     * 开始请求数据
     */
    abstract fun start()

    /**
     * 控制多状态视图显示
     */

    fun showMyMultipleStatusView(status: Int) {
        //如果已经显示过内容视图，后续遇到错误依然显示内筒视图，不做视图切换
        if (mLayoutStatusView!!.viewStatus==MultipleStatusView.STATUS_CONTENT)return
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