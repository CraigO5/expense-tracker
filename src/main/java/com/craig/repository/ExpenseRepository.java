package com.craig.repository;

import com.craig.model.Expense;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ExpenseRepository {
  private final List<Expense> expenses = new ArrayList<>();
  private final Map<String, Double> categoryTotals = new HashMap<>();
  private final Map<LocalDate, Double> expenseTrend = new TreeMap<>();

  // Adds an expense to the list and updates the category totals and expense trend
  public void addExpense(Expense expense) {
    expenses.add(expense);

    String category = expense.getCategory();
    double amount = expense.getAmount();
    LocalDate date = expense.getDate();

    if (categoryTotals.containsKey(category)) {
      double newTotal = categoryTotals.get(category) + amount;
      categoryTotals.put(category, newTotal);
    } else {
      categoryTotals.put(category, amount);
    }

    double dateTotal = expenseTrend.getOrDefault(date, 0.0);
    expenseTrend.put(date, dateTotal + amount);
  }

  public List<Expense> getAllExpenses() {
    return new ArrayList<>(expenses);
  }

  public Map<String, Double> getCategoryTotals() {
    return new HashMap<>(categoryTotals);
  }

  public Map<LocalDate, Double> getExpenseTrend() {
    return new TreeMap<>(expenseTrend);
  }
}
