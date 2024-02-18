package com.reginah.Expensetrackerapi.controller;

import com.reginah.Expensetrackerapi.entity.Expense;
import com.reginah.Expensetrackerapi.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Expense getExpenseById(@PathVariable() Long id) {
        return expenseService.getExpenseById(id);
    }

    @DeleteMapping("/expenses")
    public String deleteExpenseById(@RequestParam() Long id) {
        return "Deleting the expense object by its id" + id;

    }

}
