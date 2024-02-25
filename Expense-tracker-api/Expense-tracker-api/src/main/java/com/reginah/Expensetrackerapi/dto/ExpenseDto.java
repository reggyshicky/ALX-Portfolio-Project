package com.reginah.Expensetrackerapi.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.Date;

public record ExpenseDto(

        @Column(name = "expense_name")
        @NotBlank(message = "Expense name must not be null")
        @Size(min=3, message = "Expense name must be atleast 3 characters")
        String name,

        String description,

        @Column(name = "expense_amount")
        @NotNull(message = "Expense amount should not be null")
        BigDecimal amount,

        @NotBlank(message = "Category should not be null")
        String category,

        @NotNull(message = "Date must not be null")
        Date date
) { }
