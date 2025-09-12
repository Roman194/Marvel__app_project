package com.example.marvel_app_project.data.network.Either

/**
 * [Either] is a approach of getting data from the internet. It's handle 2 states: [Success] and [Fail].
 * The first one will be send as a response if it will be successful, the second one - when not.
 * This project uses custom Either realization from https://proandroiddev.com/retrofit-calladapter-for-either-type-2145781e1c20
 *
 * @author Zyuzin Roman
 */
sealed class Either<out F, out S> {

    data class Fail<out F> internal constructor(val value: F) : Either<F, Nothing>() {
        companion object {
            operator fun <F> invoke(f: F): Either<F, Nothing> = Fail(f)
        }
    }

    data class Success<out S> internal constructor(val value: S) : Either<Nothing, S>() {
        companion object {
            operator fun <S> invoke(s: S): Either<Nothing, S> = Success(s)
        }
    }

    companion object {
        fun <S> success(value: S): Either<Nothing, S> = Success(value)
        fun <F> fail(value: F): Either<F, Nothing> = Fail(value)
    }
}