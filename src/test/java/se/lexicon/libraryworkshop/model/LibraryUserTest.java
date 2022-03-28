package se.lexicon.libraryworkshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class LibraryUserTest {

    private final Long id = 999999999999999999L;
    private final LocalDate localDate = LocalDate.MAX;
    private final String name = "Test Testsson";
    private final String email = "test@test.com";
    private LibraryUser testObject;

    @BeforeEach
    void setUp() {
        testObject = new LibraryUser(id, localDate, name, email);
    }


    @Test
    void test_toString() {
        String toString = testObject.toString();

        assertTrue(toString.contains(id.toString()));
        assertTrue(toString.contains(localDate.toString()));
        assertTrue(toString.contains(name));
        assertTrue(toString.contains(email));
    }
}