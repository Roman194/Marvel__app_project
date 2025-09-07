package com.example.marvel_app_project.models.data.network

data class ErrorResponse(
    val errorNumber: Int,
    val errorMessage: String = "",
    val errorCause: String = "",
){
    companion object{
        fun getValue(code: Int): ErrorResponse {
            return ErrorResponse(code)
        }
    }
}