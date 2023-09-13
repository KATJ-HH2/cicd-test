package katj.cicdtest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CicdtestApplication

fun main(args: Array<String>) {
	runApplication<CicdtestApplication>(*args)
}
