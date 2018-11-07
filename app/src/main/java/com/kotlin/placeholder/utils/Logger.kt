package com.kotlin.placeholder.utils

import android.util.Log
import kotlin.reflect.KClass

fun debug(clazz: Any, data: Any) = Log.d("${clazz::class.simpleName} ::: ", data.toString())

fun debug(clazz: KClass<*>, data: Any) = Log.d("${clazz.simpleName} ::: ", data.toString())