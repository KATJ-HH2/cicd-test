package katj.cicdtest

import de.codecentric.boot.admin.server.config.EnableAdminServer
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableAdminServer
@SpringBootApplication
class CicdtestApplication

fun main(args: Array<String>) {
	runApplication<CicdtestApplication>(*args)
}
