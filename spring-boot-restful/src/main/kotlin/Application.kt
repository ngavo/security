import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan(basePackages = arrayOf("org.controller","org.repository"))
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = arrayOf("org.repository"))
@EntityScan(basePackages = arrayOf("org.model"))
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}