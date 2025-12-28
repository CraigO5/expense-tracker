package com.craig;

import com.craig.repository.ExpenseRepository;
import com.craig.service.ExpenseService;
import com.craig.ui.ExpenseDisplay;
import com.craig.ui.InputHandler;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    // Initialize the repository and service
    ExpenseRepository repository = new ExpenseRepository();
    ExpenseService service = new ExpenseService(repository);

    // Scanner to read from the console
    Scanner scanner = new Scanner(System.in);
    // Validates the input using the InputHandler class
    InputHandler inputHandler = new InputHandler(scanner);
    // Displays the menu and handles the user input
    ExpenseDisplay display = new ExpenseDisplay(service);

    DataSeeder.seedData(service);
    runApplication(inputHandler, display, service);

    // Close scanner after the application is finished
    scanner.close();
  }

  private static void runApplication(
      InputHandler inputHandler, ExpenseDisplay display, ExpenseService service) {
    boolean running = true;

    // Runs application until option 6 is selected stopping the loop
    while (running) {
      display.showMenu();
      int choice = inputHandler.getInt("Choose an option: ");

      switch (choice) {
        case 1:
          display.showAddExpense(inputHandler);
          break;
        case 2:
          display.showTotalExpense();
          break;
        case 3:
          display.showExpenseByCategory();
          break;
        case 4:
          display.showExpenseTrend();
          break;
        case 5:
          display.showHighestLowestCategory();
          break;
        case 6:
          running = false;
          System.out.println("Exiting...");
          break;
        default:
          System.out.println("ERROR: Invalid input! Please enter one of the options below:");
      }
      // Empty line for readability
      System.out.println();
    }
  }
}
