`# Expense Tracker [![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/) [![Maven](https://img.shields.io/badge/Maven-3.6+-orange)](https://maven.apache.org/) [![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A simple command-line expense tracker built in Java. Track expenses by category, view trends, and analyze spending.

--- ## Table of Contents  - [Features](#features) - [Technologies](#technologies) - [Setup](#setup) - [Usage](#usage) - [Testing](#testing) - [Project Structure](#project-structure) - [Architecture](#architecture) - [Seed Data](#seed-data) - [Contributing](#contributing) - [License](#license)

--- ## Features  - Add expenses with category, amount, and date - View total expenses and by category - View expense trends over time - Identify highest and lowest spending categories - In-memory storage, optimized O(1) lookups ## Technologies  - Java 17 - Maven - JUnit 5 (unit tests) - Spotless (code formatting) - Checkstyle (code quality) ## Setup Clone and build:

```bash
git clone https://github.com/YOUR_USERNAME/expense-tracker.git
cd expense-tracker
mvn clean compile`

Run the application:

`mvn exec:java -Dexec.mainClass="com.craig.Main"  `

Or compile & run in one step:

`mvn clean compile exec:java -Dexec.mainClass="com.craig.Main"  `

* * * * *

Usage
-----

Menu options:

`1: Enter an expense  2: Total expense  3: Total expense by category  4: Expense trend  5: Highest/lowest category  6: Exit  `

Example workflow:

1.  Add an expense → category, amount, date

2.  View totals → total spending

3.  View by category → category totals

4.  View trends → spending over time

5.  Analyze spending → highest/lowest categories

* * * * *

Testing
-------

Run tests:

`mvn test  `

Expected: `Tests run: 7, Failures: 0, Errors: 0`

Coverage: Adding expenses, totals, category aggregation, trends, empty state handling

* * * * *

Project Structure
-----------------

`src/
└── main/java/com/craig/
    ├── Main.java ├── DataSeeder.java ├── model/Expense.java ├── repository/ExpenseRepository.java ├── service/ExpenseService.java └── ui/
        ├── ExpenseDisplay.java └── InputHandler.java  `

* * * * *

Architecture
------------

Layered design:

-   **Model** → Expense

-   **Repository** → ExpenseRepository

-   **Service** → ExpenseService

-   **UI** → ExpenseDisplay, InputHandler

Principles: SOLID, DRY, KISS\
Performance: O(1) lookups using `HashMap` and `TreeMap`

* * * * *

Seed Data
---------

Loaded on startup:

-   Food: $170 (3)

-   Transport: $55.50 (2)

-   Entertainment: $150 (2)

-   Shopping: $150 (1)\
    **Total:** $525.50

* * * * *

Contributing
------------

1.  Fork repo

2.  Create branch (`git checkout -b feature/my-feature`)

3.  Commit changes (`git commit -m "Add feature"`)

4.  Push (`git push origin feature/my-feature`)

5.  Open Pull Request
