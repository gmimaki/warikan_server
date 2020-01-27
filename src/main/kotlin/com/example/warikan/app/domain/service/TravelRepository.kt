package com.example.warikan.app.domain.service

import org.springframework.stereotype.Repository
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class TravelRepository(private val jdbcTemplate: JdbcTemplate) {

}
