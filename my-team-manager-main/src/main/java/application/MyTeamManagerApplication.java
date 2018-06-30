package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableConfigurationProperties
@ComponentScan(basePackages = {"org.samulake.web"})
@EnableJpaRepositories(basePackages = "org.samulake.web.persistence.repository")
@EntityScan(basePackages = "org.samulake.web.core.entity")
public class MyTeamManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyTeamManagerApplication.class, args);
	}
}
