package com.reginah.Expensetrackerapi.service;

import com.reginah.Expensetrackerapi.dto.ExpenseDto;
import com.reginah.Expensetrackerapi.entity.Expense;
import com.reginah.Expensetrackerapi.exceptions.ResourceNotFoundException;
import com.reginah.Expensetrackerapi.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepo;
    private final UserService userService;

    public ExpenseServiceImpl(ExpenseRepository expenseRepo, UserService userService) {
        this.expenseRepo = expenseRepo;
        this.userService = userService;
    }

    @Override
    public Page<Expense> getAllExpenses(Pageable page) {
        return expenseRepo.findAll(page);
    }

    @Override
    public Expense getExpenseById(Long id) {
        Optional<Expense> expense = expenseRepo.findById(id);
        if (expense.isPresent()) {
            return expense.get();
        } else {
            throw new ResourceNotFoundException("Expense is not found for the id " + id);
        }
    }

    @Override
    public void deleteExpenseById(Long id) {
        Expense expense = getExpenseById(id);
        expenseRepo.delete(expense);
    }

    @Override
    public ExpenseDto addExpenseDetails(ExpenseDto expense, Long userId) {
        var user = userService.readUser(userId);
        var expenseToAdd = Expense.builder()
                .user(user)
                .name(expense.name())
                .amount(expense.amount())
                .description(expense.description())
                .category(expense.category())
                .date(expense.date())
                .build();
        var savedExpenses = expenseRepo.save(expenseToAdd);
        return new ExpenseDto(savedExpenses.getName(), savedExpenses.getDescription(), savedExpenses.getAmount(), savedExpenses.getCategory(), savedExpenses.getDate());
    }

    @Override
    public Expense updateExpenseDetails(Long id, Expense expense) {
        Expense existingExpense = getExpenseById(id);
        existingExpense.setName(expense.getName() != null ? expense.getName() : existingExpense.getName());
        existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
        existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
        existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
        existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
        return expenseRepo.save(existingExpense);
    }

    @Override
    public List<Expense> readByCategory(String category, Pageable page) {
        return expenseRepo.findByCategory(category, page).toList();
    }

    @Override
    public List<Expense> readByName(String keyword, Pageable page) {
        return expenseRepo.findByNameContaining(keyword, page).toList();
    }

    @Override
    public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
        if (startDate == null) {
            startDate = new Date(0);
        }

        if (endDate == null) {
            endDate = new Date(System.currentTimeMillis());
        }

        return expenseRepo.findByDateBetween(startDate, endDate, page).toList();

        //the essence of zero is being used as a representation of the "epoch" in computing,
        // which is often defined as the starting point from which time is measured.
        //In this code, new Date(0) creates a Date object representing the epoch time,
        // which is January 1, 1970, 00:00:00 UTC. This is a commonly used reference
        // point for measuring time in many programming languages and systems.
    }
}
