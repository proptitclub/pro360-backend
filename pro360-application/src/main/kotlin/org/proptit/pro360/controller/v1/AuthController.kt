package org.proptit.pro360.controller.v1

import org.proptit.auth.domain.command.CreateNewUserCommand
import org.proptit.auth.domain.service.UserService
import org.proptit.pro360.dto.request.SignUpRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/v1/auth")
class AuthController (val userService: UserService) {

    @PostMapping("/sign-up")
    fun signUp(@RequestBody signUpRequest: SignUpRequest) : ResponseEntity<Any> {
        userService.createNewUser(CreateNewUserCommand(signUpRequest.username, signUpRequest.password))
        return ResponseEntity.ok().build()
    }

}
