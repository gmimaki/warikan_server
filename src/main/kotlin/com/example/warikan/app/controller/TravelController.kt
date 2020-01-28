package com.example.warikan.app.controller

import com.example.warikan.domain.entity.Travel
import com.example.warikan.domain.repository.TravelRepository
import com.example.warikan.error.NotFoundException
import com.example.warikan.usecase.TravelCreateForm
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("travels")
class TravelController(private val travelRepository: TravelRepository) {
    @GetMapping("")
    fun index(model: Model): List<Travel> {
        return travelRepository.findAll()
    }

    @PostMapping("")
    fun create(@Validated form: TravelCreateForm,
               bindingResult: BindingResult): String {
        if (bindingResult.hasErrors())
            return "String"

        val name = requireNotNull(form.name)
        travelRepository.create(name)
        return "String"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(): String = "Not found"
}