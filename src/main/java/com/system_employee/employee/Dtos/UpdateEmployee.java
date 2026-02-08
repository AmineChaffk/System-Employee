package com.system_employee.employee.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UpdateEmployee(


        @NotNull(message = "First name is required")
        @Size(min = 4, max = 25, message = "Size is false")
        String firstname,


        @Size(min = 4, max = 25, message = "Size is false")
        @NotNull(message = "last name is required")
        String lastname,


        @NotNull(message = "phone is required")
        @Pattern(regexp = "^(\\+\\d{1,3}( )?)?((\\(\\d{1,3}\\))|\\d{1,3})[- .]?\\d{3,4}[- .]?\\d{4}$")
        String phone,

        @NotNull
        String description,

        @Size(min = 10, max = 50)
        @NotNull(message = "position is required")
        String position
) {
}
