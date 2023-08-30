package com.season.winter.common.extensions

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

fun <T> LifecycleOwner.repeatOnLifecycle(
    flow: Flow<T>,
    lifecycleWhen: Lifecycle.State = Lifecycle.State.STARTED,
    callback: (item: T) -> Unit,
) {
    lifecycleScope.launch {
        repeatOnLifecycle(lifecycleWhen) {
            flow.collect {
                callback(it)
            }
        }
    }
}
