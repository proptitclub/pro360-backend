package org.proptit.pro360.dto.request

import javax.validation.constraints.NotNull

data class SignUpRequest(
    @NotNull
    val username: String,
    @NotNull
    val password: String
)
