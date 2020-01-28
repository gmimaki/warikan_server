package com.example.warikan.domain.repository

import com.example.warikan.domain.entity.User

interface UserRepository {
    fun create(content: String): User
}