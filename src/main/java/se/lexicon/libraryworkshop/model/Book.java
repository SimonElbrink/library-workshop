package se.lexicon.libraryworkshop.model;

import java.math.BigDecimal;
import java.time.Period;

public class Book {

    private String id;
    private String isbn;
    private String title;
    private String description;
    private Boolean available;
    private Boolean reserved;
    private BigDecimal finePerDay;
    private Period maxLoanDays;

    public Book() {
    }

    public Book(String isbn, String title, String description, Period maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.maxLoanDays = maxLoanDays;
    }

    public Book(String id, String isbn, String title, String description, Boolean available, Boolean reserved, BigDecimal finePerDay, Period maxLoanDays) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.available = available;
        this.reserved = reserved;
        this.finePerDay = finePerDay;
        this.maxLoanDays = maxLoanDays;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean getReserved() {
        return reserved;
    }

    public void setReserved(Boolean reserved) {
        this.reserved = reserved;
    }

    public BigDecimal getFinePerDay() {
        return finePerDay;
    }

    public void setFinePerDay(BigDecimal finePerDay) {
        this.finePerDay = finePerDay;
    }

    public Period getMaxLoanDays() {
        return maxLoanDays;
    }

    public void setMaxLoanDays(Period maxLoanDays) {
        this.maxLoanDays = maxLoanDays;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", ISBN='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                ", finePerDay=" + finePerDay +
                ", maxLoanDays=" + maxLoanDays +
                '}';
    }
}
