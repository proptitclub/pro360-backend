package org.proptit.pro360

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication(scanBasePackages = ["org.proptit.*"])
@EntityScan(basePackages = ["org.proptit.*"])
@EnableJpaRepositories(basePackages = ["org.proptit.*"])
class Pro360Application

fun main(args: Array<String>) {
    runApplication<Pro360Application>(*args)
}