package org.proptit.core

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.*

@MappedSuperclass
@EntityListeners(value = [AuditingEntityListener::class])
abstract class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
    @CreatedDate
    var createAt: LocalDateTime? = null
    @LastModifiedDate
    var updateAt: LocalDateTime? = null
    @Lob
    var metadata: ByteArray? = null
}