package se.lexicon.libraryworkshop.model;

import java.time.LocalDate;

public class LibraryUser {

    private Long id;
    private LocalDate regDate;
    private String name;
    private String email;

    public LibraryUser() {
    }

    public LibraryUser(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public LibraryUser(Long id, LocalDate regDate, String name, String email) {
        this.id = id;
        this.regDate = regDate;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "LibraryUser{" +
                "id=" + id +
                ", regDate=" + regDate +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
