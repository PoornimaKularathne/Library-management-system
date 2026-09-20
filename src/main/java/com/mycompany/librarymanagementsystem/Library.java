package com.mycompany.librarymanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Service class that manages items without depending on a user interface. */
public class Library {

    private final List<LibraryItem> items = new ArrayList<>();

    public boolean addItem(LibraryItem item) {
        if (item == null || searchItem(item.getItemId()) != null) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean removeItem(int itemId) {
        LibraryItem item = searchItem(itemId);
        if (item == null || item.isBorrowed()) {
            return false;
        }
        return items.remove(item);
    }

    /** Overloaded search: find one item by its unique numeric ID. */
    public LibraryItem searchItem(int itemId) {
        for (LibraryItem item : items) {
            if (item.getItemId() == itemId) {
                return item;
            }
        }
        return null;
    }

    /** Overloaded search: find every title containing the supplied text. */
    public List<LibraryItem> searchItem(String title) {
        if (title == null || title.isBlank()) {
            return Collections.emptyList();
        }
        List<LibraryItem> matches = new ArrayList<>();
        String query = title.trim().toLowerCase();
        for (LibraryItem item : items) {
            if (item.getTitle().toLowerCase().contains(query)) {
                matches.add(item);
            }
        }
        return matches;
    }

    public boolean borrowItem(int itemId) {
        LibraryItem item = searchItem(itemId);
        return item != null && item.borrowItem();
    }

    public boolean returnItem(int itemId) {
        LibraryItem item = searchItem(itemId);
        return item != null && item.returnItem();
    }

    public List<LibraryItem> getItems() {
        return Collections.unmodifiableList(items);
    }
}
