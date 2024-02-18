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
    public  void deleteExpenseById(@RequestParam() Long id) {
        expenseService.deleteExpenseById(id);
    }

    @PostMapping("/expenses")
    public Expense addExpenseDetails(@RequestBody Expense expense) {
        return expenseService.addExpenseDetails((expense));
    }

    @PutMapping("/expenses/{id}")
    public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
        return expenseService.updateExpenseDetails(id, expense);
    }


}
