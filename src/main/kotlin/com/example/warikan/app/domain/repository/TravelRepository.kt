package com.example.warikan.app.domain.repository

import com.example.warikan.app.domain.entity.Travel

interface TravelRepository {
    fun create(content: String): Travel
    fun findAll(): List<Travel>
}