package com.example.warikan.usecase

import org.hibernate.validator.constraints.NotBlank
import javax.validation.constraints.Size

class UserCreateForm {
    @NotBlank
    @Size(max=100)
    var name: String? = null
}