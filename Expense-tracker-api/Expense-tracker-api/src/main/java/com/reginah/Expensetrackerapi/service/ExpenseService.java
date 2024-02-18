package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.entity.Expense;

import java.util.List;


public interface ExpenseService {
    List<Expense> getAllExpenses();
    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    Expense addExpenseDetails(Expense expense); //saveExpenseDetails

    Expense updateExpenseDetails(Long id, Expense expense);

}
