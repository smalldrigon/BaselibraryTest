package com.grgbanking.baselibrary.baseadapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 *
 *@fileName BaseAdapter
 *@data on 2019/4/11  9:46
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 通用adapter
 **/
abstract class BaseAdapter<T>(var mContext:Context,var mData:ArrayList<T>,
                           private var mLayoytId:Int): RecyclerView.Adapter<ViewHolder>(){
    protected var mInflater:LayoutInflater? = null
    private var mTypeSupport: MultipleType<T>? = null

    //回调点击事件
    private var mItemClickListener:OnItemClickListener? = null

    //回调条目长按事件
    private  var mItemLongClickListener:OnItemLongClickListener? = null

    init {
        mInflater = LayoutInflater.from(mContext)
    }

    //需要多布局
    constructor(context: Context,data: ArrayList<T>,typeSupport:MultipleType<T>):this(context,data,-1){
        this.mTypeSupport = typeSupport
    }

//        fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
//
//        if (mTypeSupport != null){
//                //需要多布局
//            mLayoytId = viewType
//        }
//        //创建view
//        val view  = mInflater?.inflate(mLayoytId,parent,false)
//        return ViewHolder(view!!)
//    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        if (mTypeSupport != null){
            //需要多布局
            mLayoytId = p1
        }
        //创建view
        val view  = mInflater?.inflate(mLayoytId,p0,false)
        return ViewHolder(view!!)

    }

    fun getContext():Context{
        return mContext
    }

    override fun getItemViewType(position: Int): Int {
        //多布局
        return mTypeSupport?.getLayoutId(mData[position],position)?:super.getItemViewType(position)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        bindData(holder,mData[position],position)

        //点击事件
        mItemClickListener?.let {
            holder.itemView.setOnClickListener { mItemClickListener!!.onItemClick(mData[position],position) }
        }//点击事件



        //长按点击事件
        mItemLongClickListener?.let {
            holder.itemView.setOnLongClickListener { mItemLongClickListener!!.onItemLongClick(mData[position], position) }
        }

    }
    /**
     * 将必要参数传递出去
     *
     * @param holder
     * @param data
     * @param position
     */
    protected abstract fun bindData(holder: ViewHolder, data: T, position: Int)

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setOnItemClickListener(itemClickListener: OnItemClickListener) {
        this.mItemClickListener = itemClickListener
    }

    fun setOnItemLongClickListener(itemLongClickListener: OnItemLongClickListener) {
        this.mItemLongClickListener = itemLongClickListener
    }

}