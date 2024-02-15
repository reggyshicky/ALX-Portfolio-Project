package com.reginah.Expensetrackerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExpenseController {
    @GetMapping("/expenses")
    public String getAllExpenses() {
        return "List of Expenses";
    }

}