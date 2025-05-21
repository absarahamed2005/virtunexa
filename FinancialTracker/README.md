# Financial Tracker

A Java-based application to track expenses and set savings goals.

## Features
- Add expenses with date, category, and description
- Set monthly savings goals
- View monthly expense reports
- Data stored using SQLite via JDBC

## How to Run
1. Initialize the database:
   - Use the script in `database/init.sql` to create the tables.

2. Compile:
   - `javac -cp ".;lib/sqlite-jdbc-<version>.jar" src/**/*.java`

3. Run:
   - `java -cp ".;lib/sqlite-jdbc-<version>.jar" com.fintrack.main.Main`
