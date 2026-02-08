package com.system_employee.employee.Dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UpdateDepartment(
        @NotNull
        @Size(min = 5, max = 30)
        String name
) {
}
