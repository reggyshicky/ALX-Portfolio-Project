package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.entity.Expense;

import java.util.List;


public interface ExpenseService {
    List<Expense> getAllExpenses();
}
