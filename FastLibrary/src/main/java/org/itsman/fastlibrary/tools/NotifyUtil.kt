package org.itsman.fastlibrary.tools

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import org.itsman.fastlibrary.R

fun sendNotify(context: Context) {

    val notifServer = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.O) {
        val channel =
            NotificationChannel("test", "base", NotificationManager.IMPORTANCE_HIGH)
        notifServer.createNotificationChannel(channel)
    }
    val notifi = NotificationCompat.Builder(context, "test").setContentText("Test")
        .setContentTitle("Test")
        .setSmallIcon(R.mipmap.calories_icon)
        .setAutoCancel(true)
        .build()
    notifServer.notify(123, notifi)
}