package se.lexicon.libraryworkshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.Period;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    public static final String UUID = "a2cc7d9e-e12a-4080-a96b-ecb4e885b5de";
    public static final String ISBN = "ISBN-978-3-16-000000-0";
    public static final String TITLE = "A Book-Title";
    public static final String DESCRIPTION = "The book with a empty description";
    public static final Period MAX_LOAN_DAYS = Period.ofDays(14);

    private Book testObject;

    @BeforeEach
    void setUp() {
        testObject = new Book(UUID,
                ISBN,
                TITLE,
                DESCRIPTION,
                Boolean.TRUE,
                Boolean.FALSE,
                BigDecimal.TEN,
                MAX_LOAN_DAYS);
    }

    @Test
    void test_toString() {
        String toString = testObject.toString();

        assertTrue(toString.contains(UUID));
        assertTrue(toString.contains(ISBN));
        assertTrue(toString.contains(TITLE));
        assertTrue(toString.contains(DESCRIPTION));
        assertTrue(toString.contains("available=" + Boolean.TRUE));
        assertTrue(toString.contains("reserved=" + Boolean.FALSE));
        assertTrue(toString.contains(BigDecimal.TEN.toString()));
        assertTrue(toString.contains(MAX_LOAN_DAYS.toString()));
    }
}