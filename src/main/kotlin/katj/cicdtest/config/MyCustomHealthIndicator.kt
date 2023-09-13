package katj.cicdtest.config

import org.springframework.boot.actuate.health.Health
import org.springframework.boot.actuate.health.HealthIndicator
import org.springframework.stereotype.Component

@Component
class MyCustomHealthIndicator: HealthIndicator {

    override fun health(): Health {

        val freeMemory = Runtime.getRuntime().freeMemory()
        val totalMemory = Runtime.getRuntime().totalMemory()
        val freeMemoryPercent: Double = (freeMemory.toDouble() / totalMemory.toDouble()) * 100

        return if (freeMemoryPercent > 15) {
            Health.up()
                .withDetail("free_memory", "$freeMemory bytes")
                .withDetail("total_memory", "$totalMemory bytes")
                .withDetail("free_memory_percent", "$freeMemoryPercent bytes")
                .build()
        } else {
            Health.down()
                .withDetail("free_memory", "$freeMemory bytes")
                .withDetail("total_memory", "$totalMemory bytes")
                .withDetail("free_memory_percent", "$freeMemoryPercent bytes")
                .build()
        }
    }
}