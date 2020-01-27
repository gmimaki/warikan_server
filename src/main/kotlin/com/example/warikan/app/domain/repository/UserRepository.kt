package com.example.warikan.app.domain.repository

import com.example.warikan.app.domain.entity.User

interface UserRepository {
    fun create(content: String): User
}