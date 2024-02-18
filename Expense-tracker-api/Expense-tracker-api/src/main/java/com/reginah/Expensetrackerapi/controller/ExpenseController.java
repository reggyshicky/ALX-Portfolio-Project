package com.reginah.Expensetrackerapi.controller;

import com.reginah.Expensetrackerapi.entity.Expense;
import com.reginah.Expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<Expense> getAllExpenses() {
        return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public String getExpenseById(@PathVariable("id") Long id) {
        return "The expense id is " + id;
    }

}
