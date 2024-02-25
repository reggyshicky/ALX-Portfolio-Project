package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.dto.ExpenseDto;
import com.reginah.Expensetrackerapi.entity.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.util.List;


public interface ExpenseService {
    Page<Expense> getAllExpenses(Pageable page);
    Expense getExpenseById(Long id);

    void deleteExpenseById(Long id);

    ExpenseDto addExpenseDetails(ExpenseDto expense, Long userId); //saveExpenseDetails

    Expense updateExpenseDetails(Long id, Expense expense);

    List<Expense> readByCategory(String category, Pageable page);

    List<Expense> readByName(String keyword, Pageable page);

    List<Expense> readByDate(Date startDate, Date endDate, Pageable page);



}
