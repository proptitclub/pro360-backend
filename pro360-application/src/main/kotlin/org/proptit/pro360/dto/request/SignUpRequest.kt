package org.proptit.pro360.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class SignUpRequest(
    @NotNull(message = "User must not be null")
    @NotEmpty
    @NotBlank(message = "Username must not be blank")
    val username: String,
    @NotNull(message = "Password must not be null")
    @NotEmpty
    @NotBlank(message = "Password must not be blank")
    val password: String
)
