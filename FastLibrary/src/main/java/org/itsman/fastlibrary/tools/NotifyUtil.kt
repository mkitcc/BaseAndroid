package org.itsman.fastlibrary.tools

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresPermission
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationChannelCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import org.itsman.fastlibrary.R
import kotlin.random.Random

fun sendNotify(context: Context) {

    val channelID = "FastLibrary"
    val channelName = "测试通知"
//    val notifServer = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
//        val channel =
//            NotificationChannel(channelID, channelName, NotificationManager.IMPORTANCE_HIGH)
//        notifServer.createNotificationChannel(channel)
//    }
//    val notifi = NotificationCompat.Builder(context, channelID).setContentText("Test")
//        .setContentTitle("Test")
//        .setSmallIcon(R.mipmap.calories_icon)
//        .setAutoCancel(true)
//        .build()
//    notifServer.notify(123, notifi)

    //
    val nsc = NotificationManagerCompat.from(context)
    //创建channel
    val channel =
        NotificationChannelCompat.Builder(channelID, NotificationManager.IMPORTANCE_HIGH)
            .setName(channelName)
            .setShowBadge(true)
            .build()
    //创建通知
    val notifi = NotificationCompat.Builder(context, channelID).setContentText("Test")
        .setContentTitle("Test")
        .setSmallIcon(R.mipmap.calories_icon)
        .setAutoCancel(true)
        .build()
    nsc.createNotificationChannel(channel)
    val notifServer = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    notifServer.notify(Random.nextInt(),notifi)
}