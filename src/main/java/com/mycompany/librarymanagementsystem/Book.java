package com.mycompany.librarymanagementsystem;

/** A library book with author and ISBN information. */
public class Book extends LibraryItem {

    private String author;
    private String isbn;

    public Book(int itemId, String title, String author, String isbn) {
        super(itemId, title);
        setAuthor(author);
        setIsbn(isbn);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Author cannot be blank.");
        }
        this.author = author.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.isBlank()) {
            throw new IllegalArgumentException("ISBN cannot be blank.");
        }
        this.isbn = isbn.trim();
    }

    @Override
    public double calculateFine(int overdueDays) {
        validateOverdueDays(overdueDays);
        return overdueDays * 1.00;
    }

    @Override
    public String getDetails() {
        return "Book [ID=" + getItemId() + ", title=" + getTitle()
                + ", author=" + author + ", ISBN=" + isbn
                + ", borrowed=" + isBorrowed() + "]";
    }
}
