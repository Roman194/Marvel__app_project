package com.example.marvel_app_project.network.Either

import com.example.marvel_app_project.models.data.network.ErrorResponse
import retrofit2.Call
import retrofit2.CallAdapter
import java.lang.reflect.Type

class EitherCallAdapter<R>(
    private val successType: Type
) : CallAdapter<R, Call<Either<ErrorResponse, R>>> {

    override fun adapt(call: Call<R>): Call<Either<ErrorResponse, R>> = EitherCall(call, successType)

    override fun responseType(): Type = successType
}