package com.craig.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

// Validates and handles inputs from the user
public class InputHandler {
  private final Scanner scanner;
  private final DateTimeFormatter dateFormatter;

  public InputHandler(Scanner scanner) {
    this.scanner = scanner;
    this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  }

  // Just a string trim, no validation
  public String getString(String prompt) {
    System.out.print(prompt);
    return scanner.nextLine().trim();
  }

  // Ensure the input is an integer
  public int getInt(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("ERROR: Invalid input. Enter a number.");
      }
    }
  }

  // Ensure the input is a double
  public double getDouble(String prompt) {
    while (true) {
      try {
        System.out.print(prompt);
        return Double.parseDouble(scanner.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("ERROR: Invalid input. Enter a valid float number.");
      }
    }
  }

  // Ensure the input is a date in the format yyyy-MM-dd
  public LocalDate getDate(String prompt) {
    System.out.print(prompt);
    String input = scanner.nextLine().trim();

    if (input.isEmpty()) {
      return LocalDate.now();
    }

    try {
      return LocalDate.parse(input, dateFormatter);
    } catch (DateTimeParseException e) {
      System.out.println("ERROR: Invalid date format. Using today's date.");
      return LocalDate.now();
    }
  }
}
