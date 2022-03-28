package se.lexicon.libraryworkshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LoanTest {

    public static final Long ID = 1000000000000000000L;
    private Loan testObject;

    @BeforeEach
    void setUp() {
        testObject = new Loan(ID,
                LocalDate.MIN,
                Boolean.FALSE,
                new LibraryUser(),
                new Book());
    }

    @Test
    void test_toString() {
        String toString = testObject.toString();

        assertTrue(toString.contains(ID.toString()));
        assertTrue(toString.contains(LocalDate.MIN.toString()));
        assertTrue(toString.contains(Boolean.FALSE.toString()));
    }
}