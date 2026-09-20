package com.mycompany.librarymanagementsystem;

/**
 * Abstract base type for every item that can be managed by the library.
 * It centralizes the state shared by books, journals, and future item types.
 */
public abstract class LibraryItem {

    private final int itemId;
    private String title;
    private boolean borrowed;

    public LibraryItem(int itemId, String title) {
        if (itemId <= 0) {
            throw new IllegalArgumentException("Item ID must be positive.");
        }
        this.itemId = itemId;
        setTitle(title);
    }

    public int getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title.trim();
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    /** Returns false when an already-borrowed item is requested again. */
    public boolean borrowItem() {
        if (borrowed) {
            return false;
        }
        borrowed = true;
        return true;
    }

    /** Returns false when an item that is not on loan is returned. */
    public boolean returnItem() {
        if (!borrowed) {
            return false;
        }
        borrowed = false;
        return true;
    }

    public abstract double calculateFine(int overdueDays);

    public abstract String getDetails();

    protected void validateOverdueDays(int overdueDays) {
        if (overdueDays < 0) {
            throw new IllegalArgumentException("Overdue days cannot be negative.");
        }
    }
}
