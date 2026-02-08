package com.system_employee.employee.Dtos;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record CreateLeave(
        @NotNull(message = "Start Date is required")
        @FutureOrPresent(message = "Start date should be new or in the future")
        LocalDate startDate,

        @NotNull(message = "End Date is required")
        @FutureOrPresent(message = "End date should be new or in the future")
        LocalDate endDate,

        @NotNull(message = "reason is required")
        @Size(max = 100)
        String reason
) {
}
