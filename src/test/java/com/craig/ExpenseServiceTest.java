package com.craig;

import static org.junit.jupiter.api.Assertions.*;

import com.craig.repository.ExpenseRepository;
import com.craig.service.ExpenseService;
import java.time.LocalDate;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExpenseServiceTest {
  private ExpenseService service;
  private ExpenseRepository repository;

  @BeforeEach
  void setUp() {
    repository = new ExpenseRepository();
    service = new ExpenseService(repository);
  }

  // Test that adding an expense works
  @Test
  void testAddExpense() {
    service.addExpense("Food", 50.0, LocalDate.now());
    assertEquals(1, service.getAllExpenses().size());
  }

  // Test that the total expense is calculated correctly
  @Test
  void testGetTotalExpense() {
    service.addExpense("Food", 50.0, LocalDate.now());
    service.addExpense("Transport", 25.0, LocalDate.now());
    assertEquals(75.0, service.getTotalExpense(), 0.01);
  }

  // Test that the total expense by category is calculated correctly
  @Test
  void testGetTotalExpenseByCategory() {
    service.addExpense("Food", 50.0, LocalDate.now());
    service.addExpense("Food", 30.0, LocalDate.now());
    service.addExpense("Transport", 25.0, LocalDate.now());

    Map<String, Double> categoryTotals = service.getTotalExpenseByCategory();
    assertEquals(80.0, categoryTotals.get("Food"), 0.01);
    assertEquals(25.0, categoryTotals.get("Transport"), 0.01);
  }

  // Test that the highest spend category is calculated correctly
  @Test
  void testGetHighestSpendCategory() {
    service.addExpense("Food", 100.0, LocalDate.now());
    service.addExpense("Transport", 25.0, LocalDate.now());
    assertEquals("Food", service.getHighestSpendCategory());
  }

  // Test that the lowest spend category is calculated correctly
  @Test
  void testGetLowestSpendCategory() {
    service.addExpense("Food", 100.0, LocalDate.now());
    service.addExpense("Transport", 25.0, LocalDate.now());
    assertEquals("Transport", service.getLowestSpendCategory());
  }

  // Test that the expense trend is calculated correctly
  @Test
  void testGetExpenseTrend() {
    LocalDate date1 = LocalDate.now().minusDays(2);
    LocalDate date2 = LocalDate.now();

    service.addExpense("Food", 50.0, date1);
    service.addExpense("Food", 30.0, date1);
    service.addExpense("Transport", 25.0, date2);

    Map<LocalDate, Double> trend = service.getExpenseTrend();
    assertEquals(80.0, trend.get(date1), 0.01);
    assertEquals(25.0, trend.get(date2), 0.01);
  }

  // Test that the empty expenses are handled correctly
  @Test
  void testEmptyExpenses() {
    assertEquals(0.0, service.getTotalExpense(), 0.01);
    assertTrue(service.getTotalExpenseByCategory().isEmpty());
    assertEquals("No expenses found", service.getHighestSpendCategory());
  }
}
