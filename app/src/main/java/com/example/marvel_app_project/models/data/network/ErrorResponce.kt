package com.example.marvel_app_project.models.data.network

data class ErrorResponse(
    val errorNumber: Int
){
    companion object{
        fun getValue(code: Int): ErrorResponse {
            return ErrorResponse(code)
        }
    }
}
