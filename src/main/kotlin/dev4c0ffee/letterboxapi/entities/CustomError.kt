package dev4c0ffee.letterboxapi.entities

class CustomError(
    var errorMessage: String,
    var errorDetail: String = "",
) : Exception() {
}