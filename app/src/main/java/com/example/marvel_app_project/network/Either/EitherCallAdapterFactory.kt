package com.example.marvel_app_project.network.Either

import com.example.marvel_app_project.models.data.network.ErrorResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

internal class EitherCallAdapterFactory : CallAdapter.Factory() {

    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        //return type must be Call
        if (getRawType(returnType) != Call::class.java) return null
        check(returnType is ParameterizedType) { "Return type must be a parameterized type." }

        //response type must be Either
        val responseType = getParameterUpperBound(0, returnType)
        if (getRawType(responseType) != Either::class.java) return null
        check(responseType is ParameterizedType) { "Response type must be a parameterized type." }

        //Either.fail type must be ErrorResponse
        val leftType = getParameterUpperBound(0, responseType)
        if (getRawType(leftType) != ErrorResponse::class.java) return null

        //Only if its all true we will try to adapt retrofit response to Either type
        val rightType = getParameterUpperBound(1, responseType)
        return EitherCallAdapter<Any>(rightType)
    }
}




