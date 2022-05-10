package org.proptit.auth.domain.service

import mu.KotlinLogging
import org.proptit.auth.domain.command.CreateNewUserCommand
import org.proptit.auth.domain.exception.AuthException
import org.proptit.auth.domain.model.User
import org.proptit.auth.domain.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class UserService(val userRepo: UserRepository) : UserDetailsService {

    private val logger = KotlinLogging.logger {  }

    // TODO This is example
    @Transactional
    fun createNewUser(createNewUserCommand: CreateNewUserCommand) {
        logger.info("Create new user: ${createNewUserCommand.username}")
        if (createNewUserCommand.isValid()) {
            userRepo.save(createNewUserCommand.let { User(it.username, it.password) })
        } else {
            throw AuthException.UsernameIsMalFormed()
        }
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        if (username.isNullOrEmpty()) {
            throw IllegalArgumentException("Username must not be null!")
        } else {
            return userRepo.findByUsername(username)
        }
    }
}