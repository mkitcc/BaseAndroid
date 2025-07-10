package org.itsman.fastlibrary.tools.permission

import android.Manifest
import android.app.Activity
import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.Settings
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

//权限相关的代码
object RequestPermission {

    //检察是否有权限
    fun hasPermission(context: Context, i: String): Boolean {
        return ActivityCompat.checkSelfPermission(context, i) == PackageManager.PERMISSION_GRANTED
    }

    fun request(context: Context, i: String, result: (Unit) -> Unit) {
        RequestPermissionAc.start(context, i, result)
    }

    //检查通知
    fun checkNotification(context: Context): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return ActivityCompat.checkSelfPermission(
                context, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
        } else {
            return true
        }
    }

    //是否有小窗口权限
    fun checkDrawOverlays(context: Context) = if (Settings.canDrawOverlays(context)) {
        true
    } else {
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + context.packageName)
        )
        context.startActivity(intent)
        false
    }

    fun checkAllFile(context: Context) {

//       if (!Environment.isExternalStorageManager())
    }
}

class RequestPermissionAc : AppCompatActivity() {

    companion object {
        const val permissionsTag = "permissionsTag"
        fun start(context: Context, permissions: String, result: (Unit) -> Unit) {
            val intent = Intent(context, RequestPermissionAc::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP) //开启新的任务栈并且清除栈顶...为何要清除栈顶
            intent.putExtra(permissionsTag, permissions)
            context.startActivity(intent)
            if (context is Activity) {
                context.overridePendingTransition(0, 0)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val permission = intent.getStringExtra(permissionsTag)

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            finish()
            return
        }
        requestPermissions(arrayOf(permission), 1234)
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {

        }
        overridePendingTransition(0, 0)
    }

}