package org.itsman.fastlibrary.tools

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters



class MyWork(val context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {

    override fun doWork(): Result {

        sendNotify(context)
        return Result.success()
    }

    companion object{
        fun build(context: Context){
            val aa = OneTimeWorkRequestBuilder<MyWork>().build()
//            WorkManager.getInstance(context).enqueue(aa)
            WorkManager.getInstance(context).enqueueUniqueWork("asdf", ExistingWorkPolicy.REPLACE,aa)
        }
    }
}