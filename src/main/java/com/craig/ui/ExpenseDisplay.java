package com.craig.ui;

import com.craig.service.ExpenseService;
import java.time.LocalDate;
import java.util.Map;

public class ExpenseDisplay {
  private final ExpenseService service;

  public ExpenseDisplay(ExpenseService service) {
    this.service = service;
  }

  public void showMenu() {
    System.out.println("1: Enter an expense");
    System.out.println("2: Total expense");
    System.out.println("3: Total expense by category");
    System.out.println("4: Expense trend");
    System.out.println("5: Highest and lowest spend category");
    System.out.println("6: Exit");
  }

  public void showAddExpense(InputHandler inputHandler) {
    System.out.println("\nADD EXPENSE:");
    String category = inputHandler.getString("Enter category: ");
    double amount = inputHandler.getDouble("Enter amount in dollars (Ex: 100.00): ");
    var date = inputHandler.getDate("Enter date (yyyy-MM-dd) or press Enter for today: ");

    service.addExpense(category, amount, date);
    System.out.println("Expense added successfully!");
  }

  // Amounts are stored as floats on the backend. Ensures that it's displayed rounded to two decimal
  // places
  private String convertToCurrency(double amount) {
    return String.format("$%.2f", amount);
  }

  public void showTotalExpense() {
    double total = service.getTotalExpense();
    System.out.println("TOTAL EXPENSE: " + convertToCurrency(total));
  }

  public void showExpenseByCategory() {
    System.out.println("\nEXPENSE BY CATEGORY:");
    Map<String, Double> categoryTotals = service.getTotalExpenseByCategory();

    if (categoryTotals.isEmpty()) {
      System.out.println("No expenses yet! Add an expense with the 1 command.");
      return;
    }

    // Displays each category and its total amount in currency format
    categoryTotals.forEach(
        (category, total) -> System.out.println(category + ": " + convertToCurrency(total)));
  }

  public void showExpenseTrend() {
    System.out.println("\nEXPENSE TREND:");
    Map<LocalDate, Double> expenseTrend = service.getExpenseTrend();

    if (expenseTrend.isEmpty()) {
      System.out.println("No expenses yet! Add an expense with the 1 command.");
      return;
    }

    expenseTrend.forEach(
        (trend, total) -> System.out.println(trend + ": " + convertToCurrency(total)));
  }

  public void showHighestLowestCategory() {
    Map<String, Double> categoryTotals = service.getTotalExpenseByCategory();

    if (categoryTotals.isEmpty()) {
      System.out.println("No expenses yet! Add an expense with the 1 command.");
      return;
    }

    String highest = service.getHighestSpendCategory();
    String lowest = service.getLowestSpendCategory();

    System.out.println(
        "HIGHEST SPEND CATEGORY: "
            + highest
            + " ("
            + convertToCurrency(categoryTotals.get(highest))
            + ")");
    System.out.println(
        "LOWEST SPEND CATEGORY: "
            + lowest
            + " ("
            + convertToCurrency(categoryTotals.get(lowest))
            + ")");
  }
}
