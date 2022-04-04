package se.lexicon.libraryworkshop.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "book_loan")

public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    private LocalDate loanDate;

    @Column(name = "concluded")
    private Boolean terminated;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_library_user_id")
    private LibraryUser loanTaker;

    @ManyToOne(
            cascade = {CascadeType.REFRESH, CascadeType.PERSIST},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "fk_book_id")
    private Book book;

    public Loan() {
        this.loanDate = LocalDate.now();
        this.terminated = Boolean.FALSE;
    }

    public Loan(LibraryUser loanTaker, Book book) {
        this();
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
