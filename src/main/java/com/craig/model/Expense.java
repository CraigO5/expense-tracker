package com.craig.model;

import java.time.LocalDate;

// Expense class with category, amount, and date
public class Expense {
  private String category;
  private double amount;
  private LocalDate date;

  public Expense(String category, double amount, LocalDate date) {
    this.category = category;
    this.amount = amount;
    this.date = date;
  }

  //   Getters for the fields
  //   Note: Setters are unneeded due to the fields never being modified

  public String getCategory() {
    return category;
  }

  public double getAmount() {
    return amount;
  }

  public LocalDate getDate() {
    return date;
  }
}
