package com.example.warikan.app.controller

import com.example.warikan.domain.entity.User
import com.example.warikan.domain.repository.UserRepository
import com.example.warikan.error.NotFoundException
import com.example.warikan.usecase.UserCreateForm
import org.springframework.http.HttpStatus
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(private val userRepository: UserRepository) {
    @GetMapping("")
    fun index(model: Model): List<User> {
        return userRepository.findAll()
    }

    @PostMapping("")
    fun create(@Validated form: UserCreateForm,
               bindingResult: BindingResult): String {
        if (bindingResult.hasErrors())
            return "string"

        val name: String = requireNotNull(form.name)
        userRepository.create(name)
        return "string"
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFoundException(): String = "Not found"
}
