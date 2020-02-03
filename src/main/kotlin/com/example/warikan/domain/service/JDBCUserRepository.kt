package com.example.warikan.domain.service

import com.example.warikan.domain.entity.User
import com.example.warikan.domain.repository.UserRepository
import com.example.warikan.error.NotFoundException
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import com.example.warikan.extenstions.queryForObject
import org.springframework.stereotype.Repository

@Repository
class JDBCUserRepository(private val jdbcTemplate: JdbcTemplate) : UserRepository {
    private val rowMapper = RowMapper<User> { rs, _ ->
        User(rs.getLong("id"), rs.getString("name"))
    }
    // TODO schema設計しっかり
    override fun create(name: String): User {
        jdbcTemplate.update("INSERT INTO user(name) VALUES(?)", name)
        val id: Long = jdbcTemplate.queryForObject("SELECT last_insert_id()") ?: throw NotFoundException()
        return User(id, name)
    }

    override fun findAll(): List<User> = jdbcTemplate.query("SELECT id, name FROM user", rowMapper)
}

