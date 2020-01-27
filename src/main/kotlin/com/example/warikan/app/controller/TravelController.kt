package com.example.warikan.app.controller

import com.example.warikan.app.domain.entity.Travel
import com.example.warikan.app.domain.repository.TravelRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("travel")
class TravelController(private val travelRepository: TravelRepository) {
    @GetMapping("")
    fun index(model: Model): List<Travel> {
        return travelRepository.findAll()
    }
}