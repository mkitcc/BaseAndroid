package org.itsman.fastlibrary.tools.scope

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * 全局协程
 */
object AppScope {

    var scopeList = mutableListOf<CoroutineScope>()

    //创建协程
    fun create(dispatcher: CoroutineDispatcher = Dispatchers.Main): CoroutineScope {
        val scope = CoroutineScope(SupervisorJob() + dispatcher)
        scopeList.add(scope)
        return scope
    }

    //取消协程
    fun destory(scope: CoroutineScope) {
        scopeList.remove(scope)
        scope.cancel()
    }
}
