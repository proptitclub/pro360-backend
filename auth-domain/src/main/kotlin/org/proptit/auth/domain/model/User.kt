package org.proptit.auth.domain.model

import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author idev
 * this entity contains authentication info (username, password)
 * @param usr : username
 * @param pwd : password
 * */
@Entity
@Table(name = "tb_user")
data class User(
    var usr: String,
    var pwd: String
) : UserDetails {

    override fun getAuthorities() = listOf(SimpleGrantedAuthority("ROLE_USER")) //TODO : this is simple role, implement role system

    override fun getPassword() = pwd

    override fun getUsername() = usr

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true

    override fun isCredentialsNonExpired() = true

    override fun isEnabled() = true // TODO : enable all user, you should implement user filter (baned, blocked,...)

}
