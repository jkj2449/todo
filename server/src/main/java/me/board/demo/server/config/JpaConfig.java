package me.board.demo.server.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "me.board.demo.server.domain.*")
@EntityScan(basePackages = "me.board.demo.server.domain.*")
@EnableJpaAuditing(auditorAwareRef = "securityAuditorAware")
@Configuration
public class JpaConfig {
}
