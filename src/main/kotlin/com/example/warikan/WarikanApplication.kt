package com.example.warikan

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootApplication
class WarikanApplication {
	@Bean
	fun commandLineRunner(jdbcTemplate: JdbcTemplate) = CommandLineRunner {
		jdbcTemplate.execute("""CREATE TABLE IF NOT EXISTS travel (
			id BIGINT PRIMARY KEY AUTO_INCREMENT,
			name VARCHAR(100) NOT NULL
		)""")
	}
}

fun main(args: Array<String>) {
    SpringApplication.run(WarikanApplication::class.java, *args)
}
