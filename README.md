Expense Tracker [![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/) [![Maven](https://img.shields.io/badge/Maven-3.6+-orange)](https://maven.apache.org/) [![License: MIT](https://img.shields.io/badge/License-MIT-green)](LICENSE)

A simple command-line expense tracker built in Java. Track expenses by category, view trends, and analyze spending.

```bash
git clone https://github.com/YOUR_USERNAME/expense-tracker.git
cd expense-tracker
mvn clean compile
```
Run the application:
```
java -cp target/classes com.craig.Main
```
* * * * *

Usage
-----

Menu options:

`1: Enter an expense 
2: Total expense 
3: Total expense by category 
4: Expense trend 
5: Highest/lowest category
6: Exit  `

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

`mvn test`

Expected: `Tests run: 7, Failures: 0, Errors: 0`

Coverage: Adding expenses, totals, category aggregation, trends, empty state handling

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
