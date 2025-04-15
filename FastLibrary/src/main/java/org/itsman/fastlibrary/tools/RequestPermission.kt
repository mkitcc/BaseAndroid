package org.itsman.fastlibrary.tools

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

//权限相关的代码
object RequestPermission {


    //检察是否有权限
    fun hasPermission(context: Context,i:String): Boolean{
        return ActivityCompat.checkSelfPermission(context,i)== PackageManager.PERMISSION_GRANTED
    }

    fun request(context:Context,i: String ,result:(Unit)-> Unit){

    }

}

class RequestPermissionAc: AppCompatActivity(){

    companion object {
        fun start(context: Context,result: (Unit)->Unit){
            val intent = Intent(context, RequestPermissionAc::class.java)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}