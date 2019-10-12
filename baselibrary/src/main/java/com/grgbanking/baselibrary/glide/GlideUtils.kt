package com.grgbanking.baselibrary.glide
import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.grgbanking.baselibrary.R

/**
 *
 *@fileName GlideUtils
 *@data on 2019/4/4  10:57
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe TODO
 **/
object GlideUtils {
    /**
     *@param context 上下文   imgpath  图片路径   view  要显示图片的控件
     *@return null
     *@exception/throws [违例类型] [违例说明]
     *@see              [类、类#方法、类#成员]
     *创建时间：
     *@author  QQ:904430803
     */
    fun showNetImage(context: Context, imgpath: String, view: ImageView) {
        Glide.with(context).load(imgpath).into(view)
    }

    fun showLocalGif(context: Context, resId: Int, view: ImageView) {
        Glide.with(context).load(resId).into(view)
    }
}