package org.itsman.fastlibrary.tools

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
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

}

class RequestPermissionAc : AppCompatActivity() {

    companion object {
        const val permissionsTag = "permissionsTag"
        fun start(context: Context, permissions: String, result: (Unit) -> Unit) {
            val intent = Intent(context, RequestPermissionAc::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP);//开启新的任务栈并且清除栈顶...为何要清除栈顶
            intent.putExtra(permissionsTag, permissions);
            context.startActivity(intent)
            if (context is Activity) {
                context.overridePendingTransition(0, 0)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val permission = intent.getStringExtra(permissionsTag)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(permission), 1234)
        }
        overridePendingTransition(0, 0)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}