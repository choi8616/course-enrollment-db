# CSE12 PA5 - Hash Table

This project implements a course enrollment system using Java's **HashSet**

## 📂 Files
- `Student.java`       : Represents a student with first name, last name, and PID
- `Course.java`        : Manages course info, student enrollment, and capacity using HashSet
- `CustomTester.java`  : Custom JUnit test cases for verifying correctness and edge case behavior

## 🌟 Features
- Java HashSet used to manage student enrollment and avoid duplicates
- Usage of `.equals()`, `.hashCode()`, and `.compareTo()` for student comparisons
- Generate sorted course rosters by student name
- Input validation with exception handling for edge cases

## 🛠️ Compile & Run Tests
You can compile and run the test cases using JUnit 4.

## Compile:
```bash
javac -cp libs/junit-4.12.jar:libs/hamcrest-core-1.3.jar:. CustomTester.java
```

(This project was completed as part of CSE12 : Basic Data Structures and Object-Oriented Design at UC San Diego)
