package org.proptit.auth.domain.exception

import org.proptit.core.BaseException
import org.proptit.core.ErrorCode

sealed class AuthException(errorCode: ErrorCode) : BaseException(errorCode) {
    class UsernameIsMalFormed: AuthException(AuthErrorCode.UsernameIsMalformed())
}

sealed class AuthErrorCode(code: String, message: String): ErrorCode(code, message) {
    class UsernameIsMalformed: AuthErrorCode(USERNAME_IS_MALFORMED_CODE, USERNAME_IS_MALFORMED_MSG)
}

const val USERNAME_IS_MALFORMED_CODE = "USERNAME_IS_MALFORMED"
const val USERNAME_IS_MALFORMED_MSG = "User name must be contain at least 8 character" // TODO this is example