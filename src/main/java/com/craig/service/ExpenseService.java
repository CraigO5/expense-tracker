package com.craig.service;

import com.craig.model.Expense;
import com.craig.repository.ExpenseRepository;
import java.time.LocalDate;
import java.util.*;

public class ExpenseService {
  private final ExpenseRepository repository;

  private double totalExpense = 0.0;
  private String highestCategory = "";
  private double highestAmount = 0.0;
  private String lowestCategory = "";
  private double lowestAmount = Double.MAX_VALUE;

  public ExpenseService(ExpenseRepository repository) {
    this.repository = repository;
  }

  // Adds an expense to the repository and updates the constants for O(1) lookup time complexity
  public void addExpense(String category, double amount, LocalDate date) {
    Expense expense = new Expense(category, amount, date);
    repository.addExpense(expense);

    totalExpense += amount;

    Map<String, Double> categoryTotals = repository.getCategoryTotals();
    double categoryTotal = categoryTotals.get(category);

    if (categoryTotal > highestAmount) {
      highestAmount = categoryTotal;
      highestCategory = category;
    }

    updateLowestCategory(categoryTotals);
  }

  // More complex than highest because it's possible that the lowest is updated and we need to scan
  // through to find the new lowest.
  private void updateLowestCategory(Map<String, Double> categoryTotals) {
    // Finds the lowest category by value
    var lowestEntry = categoryTotals.entrySet().stream().min(Map.Entry.comparingByValue());

    if (lowestEntry.isPresent()) {
      var entry = lowestEntry.get();
      lowestAmount = entry.getValue();
      lowestCategory = entry.getKey();
    }
  }

  public double getTotalExpense() {
    return totalExpense;
  }

  public Map<String, Double> getTotalExpenseByCategory() {
    return repository.getCategoryTotals();
  }

  public Map<LocalDate, Double> getExpenseTrend() {
    return repository.getExpenseTrend();
  }

  public String getHighestSpendCategory() {
    return highestCategory.isEmpty() ? "No expenses found" : highestCategory;
  }

  public String getLowestSpendCategory() {
    Map<String, Double> categoryTotals = repository.getCategoryTotals();
    return categoryTotals.isEmpty() ? "No expenses found" : lowestCategory;
  }

  public List<Expense> getAllExpenses() {
    return repository.getAllExpenses();
  }
}
