/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.librarymanagementsystem;

/** Minimal entry point; a future Swing UI can call the domain classes directly. */
public class Librarymanagementsystem {

    public static void main(String[] args) {
        Library library = new Library();
        library.addItem(new Book(101, "Clean Code", "Robert C. Martin", "978-0132350884"));
        library.addItem(new Journal(201, "Science Today", 12, 3));

        LibraryItem item = library.searchItem(101);
        if (item != null) {
            library.borrowItem(101);
            System.out.println(item.getDetails());
            System.out.println("Fine for 3 overdue days: " + item.calculateFine(3));
        }
    }
}
