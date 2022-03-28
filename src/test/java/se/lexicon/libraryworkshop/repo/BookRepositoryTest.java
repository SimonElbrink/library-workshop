package se.lexicon.libraryworkshop.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.libraryworkshop.model.Book;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BookRepositoryTest {

    @Autowired
    private BookRepository testObject;

    @Autowired
    private TestEntityManager em;

    private Book book;

    public List<Book> books(){
        return Arrays.asList(
                new Book("ISBN-978-0-7475-3269-9", "Harry Potter and the Philosopher's Stone", "Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, he faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old.", 14),
                new Book("ISBN-978-0-7475-3849-2", "Harry Potter and the Chamber of Secrets", "Harry Potter and the Chamber of Secrets is a fantasy novel written by British author J. K. Rowling and the second novel in the Harry Potter series. The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's corridors warn that the 'Chamber of Secrets' has been opened and that the 'heir of Slytherin' would kill all pupils who do not come from all-magical families. These threats are found after attacks that leave residents of the school petrified. Throughout the year, Harry and his friends Ron and Hermione investigate the attacks.",14),
                new Book("ISBN-978-0-13-767381-0", "Core Java, Volume I: Fundamentals, 12th Edition", "Core Java, Volume I: Fundamentals, Twelfth Edition, is the definitive guide to writing robust, maintainable code. Whatever version of Java you are using--up to and including Java 17--this book will help you achieve a deep and practical understanding of the language and APIs. With hundreds of realistic examples, Cay S. Horstmann reveals the most powerful and effective ways to get the job done.", 14),
                new Book("ISBN-978-0-13-787090-5", "Core Java, Volume I: Advanced Features, 12th Edition", "Core Java is the leading no-nonsense tutorial and reference for experienced programmers who want to write robust Java code for real-world applications. Now, Core Java, Volume II: Advanced Features, Twelfth Edition, has been revised to cover the new features and enhancements in the Java 17 long-term support release. As always, all chapters have been completely updated, outdated material has been removed, and the new APIs are covered in detail.", 14)
        );
    }

    @BeforeEach
    void setUp() {
        List<Book> books = books().stream()
                .map(em::persist)
                .collect(Collectors.toList());
        book = books.get(0);

    }

    @Test
    void test_created_correctly() {
        assertNotNull(book.getId());

        assertEquals(book.getIsbn(), "ISBN-978-0-7475-3269-9");
        assertEquals(book.getTitle(), "Harry Potter and the Philosopher's Stone");
        assertEquals(book.getFinePerDay(), BigDecimal.TEN);
        assertEquals(book.getMaxLoanDays(), 14);

        assertTrue(book.getDescription().startsWith("Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling."));
        assertTrue(book.getAvailable());
        assertFalse(book.getReserved());
    }

    @Test
    void test_findReserved() {

        book.setReserved(true);

        List<Book> foundBooks = testObject.findByReserved(false);
        assertEquals( 3, foundBooks.size());

    }

    @Test
    void test_findAvailable() {

        book.setAvailable(false);

        List<Book> foundBooks = testObject.findByAvailable(false);
        assertEquals(1, foundBooks.size());

    }

    @Test
    void test_findByTitleLikeIgnoreCase() {

        String title = "Harry Potter";
        List<Book> foundBooks = testObject.findByTitleContainingIgnoreCase(title);

        assertEquals(2, foundBooks.size());

    }
}