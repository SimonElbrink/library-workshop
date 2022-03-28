package se.lexicon.libraryworkshop.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.libraryworkshop.model.LibraryUser;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LibraryUserRepositoryTest {
    
    @Autowired
    private LibraryUserRepository testObject;
    
    @Autowired
    private TestEntityManager em;
    
    private LibraryUser libraryUser;

    @BeforeEach
    void setUp() {
        libraryUser = new LibraryUser("Test Testsson", "test@test.com");
       libraryUser = em.persist(libraryUser);
    }

    @Test
    @DisplayName("Creating and Saving a Lib-User to Database.")
    void test_Creation() {
        assertNotNull(libraryUser.getId());
        assertNotNull(libraryUser.getRegDate());

        assertEquals(libraryUser.getName(), "Test Testsson");
        assertEquals(libraryUser.getEmail(), "test@test.com");

//        System.out.println(libraryUser);
    }

    @Test
    @DisplayName(value = "Find By email ignoring casing - Successfully")
    void test_findByEmail() {
        Optional<LibraryUser> user = testObject.findByEmailIgnoreCase("tESt@TEST.com");

        assertTrue(user.isPresent());

    }

    @Test
    @DisplayName(value = "Find By email ignoring casing - NOT a full email")
    void test_findByEmail_not() {
        Optional<LibraryUser> user = testObject.findByEmailIgnoreCase("tESt");

        assertFalse(user.isPresent());

    }




















}