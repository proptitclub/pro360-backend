package org.proptit.core

open class BaseException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)

open class ErrorCode(
    val code: String,
    val message: String
)