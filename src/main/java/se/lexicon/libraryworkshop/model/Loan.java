package se.lexicon.libraryworkshop.model;

import java.time.LocalDate;

public class Loan {

    private Long id;
    private LocalDate loanDate;
    private Boolean terminated;
    private LibraryUser loanTaker;
    private Book book;

    public Loan() {
    }

    public Loan(LibraryUser loanTaker, Book book) {
        this.loanTaker = loanTaker;
        this.book = book;
    }

    public Loan(Long id, LocalDate loanDate, Boolean terminated, LibraryUser loanTaker, Book book) {
        this.id = id;
        this.loanDate = loanDate;
        this.terminated = terminated;
        this.loanTaker = loanTaker;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public Boolean getTerminated() {
        return terminated;
    }

    public void setTerminated(Boolean terminated) {
        this.terminated = terminated;
    }

    public LibraryUser getLoanTaker() {
        return loanTaker;
    }

    public void setLoanTaker(LibraryUser loanTaker) {
        this.loanTaker = loanTaker;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loanDate=" + loanDate +
                ", terminated=" + terminated +
                ", loanTaker=" + loanTaker +
                ", book=" + book +
                '}';
    }
}
