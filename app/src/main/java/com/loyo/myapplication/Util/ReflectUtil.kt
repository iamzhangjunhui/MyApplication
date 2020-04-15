package com.loyo.myapplication.Util;

import java.lang.reflect.ParameterizedType

class ReflectUtil {
    companion object {
        @Suppress("UNCHECKED_CAST")
        fun <T> getClass(t: Any): Class<T> {
            return (t.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>
        }
    }
}
