package org.proptit.auth.domain.command

/**
 * @author idev
 * This class contains data for a create new user command
 * @param username : username
 * @param password : password
 * */
data class CreateNewUserCommand(
    val username: String,
    val password: String
) {
    // TODO check validation of user and password
    fun isValid() = true
}