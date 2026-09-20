package com.mycompany.librarymanagementsystem;

/** A periodical library item identified by its volume and issue. */
public class Journal extends LibraryItem {

    private int volume;
    private int issueNumber;

    public Journal(int itemId, String title, int volume, int issueNumber) {
        super(itemId, title);
        setVolume(volume);
        setIssueNumber(issueNumber);
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        if (volume <= 0) {
            throw new IllegalArgumentException("Volume must be positive.");
        }
        this.volume = volume;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            throw new IllegalArgumentException("Issue number must be positive.");
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public double calculateFine(int overdueDays) {
        validateOverdueDays(overdueDays);
        return overdueDays * 1.50;
    }

    @Override
    public String getDetails() {
        return "Journal [ID=" + getItemId() + ", title=" + getTitle()
                + ", volume=" + volume + ", issue=" + issueNumber
                + ", borrowed=" + isBorrowed() + "]";
    }
}
