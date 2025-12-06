package com.example.marvel_app_project.models.data.network


/**
 * [ErrorResponse] it's a data class (model) that is used to transfer error responses data from API
 * to Repository in cases when response is [Either.Fail].
 * Later it will be converted in Repository to [HeroReserve]
 *
 * [ErrorResponse] это дата-класс, используемый для передачи ошибки при передачи фейла запроса к API [Either.Fail].
 * В дальнейшем содержимое этого дата-класса будет конвертировано в [HeroReserve]
 *
 * @author Zyuzin Roman
 */
data class ErrorResponse(
    val errorNumber: Int,
    val errorMessage: String = "",
    val errorCause: String = "",
){
    companion object{
        /**
         * This function is used as the mapper to [ErrorResponse] for [Either.Call] method
         * @param code is an HTTP-response code (error response)
         *
         * Данная функция используется в качестве маппера для [ErrorResponse] для [Either.Call].
         * параметр code это код ответа HTTP-запроса
         */
        fun getValue(code: Int): ErrorResponse {
            return ErrorResponse(code)
        }
    }
}