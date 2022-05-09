package org.proptit.auth.domain.repository

import org.proptit.auth.domain.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface UserRepository : JpaRepository<User, Long> {
    @Query("select u from User u where u.usr = :username")
    fun findByUsername(@Param("username") username: String): User
}