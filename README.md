# Library Management System

A Java Swing library management system developed for an Object-Oriented Programming coursework assignment.

## Requirements

- JDK 23 (as configured in `pom.xml`)
- Apache NetBeans
- NetBeans **Absolute Layout** library, required by the Matisse-generated forms

## How to run the application

1. Open this Maven project in Apache NetBeans.
2. Wait for NetBeans to finish loading the project dependencies.
3. In the **Projects** pane, open:

   `Source Packages > com.company.librarymanagementsystem > Login.java`

4. Right-click `Login.java` and select **Run File**.
5. The Login screen opens. Enter the following credentials:

   | Field | Value |
   | --- | --- |
   | User Name | `admin` |
   | Password | `1234` |

6. Click **Login** to open the Dashboard. From the Dashboard, use the buttons to open the Books, Members, and Borrow Book screens.

## Validation included

- Login fields cannot be empty.
- Book IDs, Member IDs, Borrow IDs, and book quantity must be positive whole numbers.
- Book and member required fields are checked before a success message is shown.
- Member email addresses and 10-digit phone numbers are validated.

## OOP backend

The backend model classes are in `src/main/java/com/mycompany/librarymanagementsystem` and demonstrate abstraction, inheritance, encapsulation, and polymorphism.
