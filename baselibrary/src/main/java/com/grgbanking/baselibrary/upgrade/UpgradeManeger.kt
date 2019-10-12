package com.gdmcmc.simplecharge.upgrade

import android.content.Context
import android.widget.Toast
import com.allenliu.versionchecklib.v2.AllenVersionChecker
import com.allenliu.versionchecklib.v2.builder.UIData

/**
 *
 *@fileName UpgradeManeger
 *@data on 2019/4/4  14:45
 *@author  xiaobiaogong
 *@email 904430803@qq.con
 *@describe 升级下载管理类,基于github 第三方简单封装 参考：https://github.com/AlexLiuSheng/CheckVersionLib/blob/master/README_UN.MD
 **/
object UpgradeManeger {
    /**
     *@param context 上下文   downloadUrl  下载的url
     *@return
     *@exception/throws [违例类型] [违例说明]
     *@see              [类、类#方法、类#成员]
     *创建时间：
     *@author  QQ:904430803
     */
    fun simpleUpgrade(context: Context, downloadUrl: String, uiData: UIData) {
        return AllenVersionChecker
                .getInstance()
                .downloadOnly(uiData.setDownloadUrl(downloadUrl))
                .setShowNotification(true)
                .setSilentDownload(false)
                .setShowDownloadFailDialog(false)
                .setForceRedownload(true)
                .executeMission(context)
    }

    /**
     * 非强制下载新版本并在通知栏显示通知,
     * @param isForceUpgrade  true  强制更新
     */
    fun simpleUpgradeWithNotification(context: Context, downloadUrl: String, uiData: UIData, isForceUpgrade: Boolean) {

        if (isForceUpgrade) {
            return AllenVersionChecker
                    .getInstance()
                    .downloadOnly(uiData.setDownloadUrl(downloadUrl))
                    .setShowNotification(true)
                    .setSilentDownload(false)//静默安装
                    .setShowDownloadFailDialog(true)
                    .setForceUpdateListener {
                        Toast.makeText(context, "强制更新", Toast.LENGTH_LONG).show()
                    }
                    .setForceRedownload(true)//如果本地有安装包缓存也会重新下载apk
                    .executeMission(context)
        } else {
            return AllenVersionChecker
                    .getInstance()
                    .downloadOnly(uiData.setDownloadUrl(downloadUrl))
                    .setShowNotification(true)
                    .setSilentDownload(false)
                    .setShowDownloadFailDialog(true)
                    .setShowDownloadingDialog(false)//是否显示下载对话框
                    .setForceRedownload(true)
                    .executeMission(context)
        }

    }


}