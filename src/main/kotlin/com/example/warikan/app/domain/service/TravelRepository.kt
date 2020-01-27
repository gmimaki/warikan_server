package com.example.warikan.app.domain.service

import com.example.warikan.app.domain.repository.TravelRepository
import org.springframework.stereotype.Repository
import com.example.warikan.app.domain.entity.Travel
import com.example.warikan.app.error.NotFoundException
import org.springframework.jdbc.core.RowMapper
import com.example.warikan.app.extenstions.queryForObject
import org.springframework.jdbc.core.JdbcTemplate

@Repository
class JDBCTravelRepository(private val jdbcTemplate: JdbcTemplate) : TravelRepository {
    private val rowMapper = RowMapper<Travel> { rs, _ ->
        Travel(rs.getLong("id"), rs.getString("name"))
    }

    override fun create(name: String): Travel {
        jdbcTemplate.update("INSERT INTO travel(name) VALUES(?)", name)
        val id: Long = jdbcTemplate.queryForObject("SELECT last_insert_id()") ?: throw NotFoundException()
        return Travel(id, name)
    }

    override fun findAll(): List<Travel> = jdbcTemplate.query("SELECT id, name FROM travel", rowMapper)
}

