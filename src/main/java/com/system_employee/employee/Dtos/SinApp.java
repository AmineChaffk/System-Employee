package com.system_employee.employee.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record SinApp(
        @NotNull
        @Size(min = 2, max = 20)
        String username,
        @NotNull
        @Size(min = 10, max = 20)
        String password,
        @NotNull(message = "employee is required")
        Integer employee_Id
) {
}
