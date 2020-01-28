package com.example.warikan.domain.repository

import com.example.warikan.domain.entity.Travel

interface TravelRepository {
    fun create(name: String): Travel
    fun findAll(): List<Travel>
}