package com.system_employee.employee.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateDepartment(
        @NotNull
        @Size(min = 2, max = 30)
        String name
) {
}
