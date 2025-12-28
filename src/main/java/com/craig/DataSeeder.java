package com.craig;

import com.craig.service.ExpenseService;
import java.time.LocalDate;

// Simple data seeder
public class DataSeeder {
  public static void seedData(ExpenseService service) {
    service.addExpense("Food", 50.00, LocalDate.now().minusDays(5));
    service.addExpense("Transport", 25.50, LocalDate.now().minusDays(4));
    service.addExpense("Food", 75.00, LocalDate.now().minusDays(3));
    service.addExpense("Entertainment", 100.00, LocalDate.now().minusDays(2));
    service.addExpense("Transport", 30.00, LocalDate.now().minusDays(1));
    service.addExpense("Food", 45.00, LocalDate.now());
    service.addExpense("Shopping", 150.00, LocalDate.now());
    service.addExpense("Entertainment", 50.00, LocalDate.now());
  }
}
