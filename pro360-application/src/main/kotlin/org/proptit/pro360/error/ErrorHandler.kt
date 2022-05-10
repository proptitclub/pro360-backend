package org.proptit.pro360.error

import org.proptit.core.BaseException
import org.proptit.core.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ErrorHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [BaseException::class])
    fun pro360ExceptionHandler(ex: BaseException) = ResponseEntity.badRequest().body(ex.let { ErrorResponse(it.errorCode.code, it.errorCode.message) })

}