package com.example.marvel_app_project.network.either

import com.example.marvel_app_project.models.data.network.ErrorResponse
import okhttp3.Request
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.IOException
import java.lang.reflect.Type

/**
 * Custom [CallAdapter.Factory] to handle Retrofit [Response] through [Either] type
 *
 * Original idea taken from:
 * https://proandroiddev.com/retrofit-calladapter-for-either-type-2145781e1c20
 */
class EitherCall<R>(
    private val delegate: Call<R>,
    private val successType: Type
) : Call<Either<ErrorResponse, R>> {

    override fun enqueue(callback: Callback<Either<ErrorResponse, R>>) = delegate.enqueue(
        object : Callback<R> {

            override fun onResponse(call: Call<R>, response: Response<R>) { // if response from the server was received
                //Success method is the only way to return success/failure cases consistently in the same Either data type from Retrofit.
                callback.onResponse(this@EitherCall, Response.success(response.toEither()))
            }

            private fun Response<R>.toEither(): Either<ErrorResponse, R> {
                if (!isSuccessful) { // if response contained http error code
                    return Either.Fail(ErrorResponse.getValue(code()))
                }

                //if response contained success http code with the response body
                body()?.let { body -> return Either.success(body) }

                //if response contained success http code without body
                return if (successType == Unit::class.java) {
                    @Suppress("UNCHECKED_CAST")
                    Either.success(Unit) as Either<ErrorResponse, R>
                } else {
                    @Suppress("UNCHECKED_CAST")
                    Either.fail(UnknownError("Response body was null")) as Either<ErrorResponse, R>
                }
            }

            override fun onFailure(call: Call<R>, throwable: Throwable) { //if connection to the server failed
                val error = when (throwable) {
                    is IOException -> ErrorResponse(700)
                    else -> ErrorResponse(800)
                }
                callback.onResponse(this@EitherCall, Response.success(Either.Fail(error)))
            }
        }
    )

    override fun clone(): Call<Either<ErrorResponse, R>> {
        TODO("Not yet implemented")
    }

    override fun execute(): Response<Either<ErrorResponse, R>> {
        TODO("Not yet implemented")
    }

    override fun isExecuted(): Boolean {
        TODO("Not yet implemented")
    }

    override fun cancel() {
        TODO("Not yet implemented")
    }

    override fun isCanceled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun request(): Request {
        TODO("Not yet implemented")
    }

    override fun timeout(): Timeout {
        TODO("Not yet implemented")
    }
}