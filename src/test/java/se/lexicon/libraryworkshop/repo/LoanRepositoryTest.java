package se.lexicon.libraryworkshop.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import se.lexicon.libraryworkshop.model.Book;
import se.lexicon.libraryworkshop.model.LibraryUser;
import se.lexicon.libraryworkshop.model.Loan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class LoanRepositoryTest {

    @Autowired
    private LoanRepository testObject;

    @Autowired
    private TestEntityManager em;

    private LibraryUser ebba;
    private LibraryUser kevin;
    private Loan loan;



    public List<Book> books = new ArrayList<>(Arrays.asList(
            new Book("ISBN-978-0-7475-3269-9", "Harry Potter and the Philosopher's Stone", "Harry Potter and the Philosopher's Stone is a fantasy novel written by British author J. K. Rowling. The first novel in the Harry Potter series and Rowling's debut novel, it follows Harry Potter, a young wizard who discovers his magical heritage on his eleventh birthday, when he receives a letter of acceptance to Hogwarts School of Witchcraft and Wizardry. Harry makes close friends and a few enemies during his first year at the school, and with the help of his friends, he faces an attempted comeback by the dark wizard Lord Voldemort, who killed Harry's parents, but failed to kill Harry when he was just 15 months old.", 14),
            new Book("ISBN-978-0-7475-3849-2", "Harry Potter and the Chamber of Secrets", "Harry Potter and the Chamber of Secrets is a fantasy novel written by British author J. K. Rowling and the second novel in the Harry Potter series. The plot follows Harry's second year at Hogwarts School of Witchcraft and Wizardry, during which a series of messages on the walls of the school's corridors warn that the 'Chamber of Secrets' has been opened and that the 'heir of Slytherin' would kill all pupils who do not come from all-magical families. These threats are found after attacks that leave residents of the school petrified. Throughout the year, Harry and his friends Ron and Hermione investigate the attacks.", 14),
            new Book("ISBN-978-0-13-767381-0", "Core Java, Volume I: Fundamentals, 12th Edition", "Core Java, Volume I: Fundamentals, Twelfth Edition, is the definitive guide to writing robust, maintainable code. Whatever version of Java you are using--up to and including Java 17--this book will help you achieve a deep and practical understanding of the language and APIs. With hundreds of realistic examples, Cay S. Horstmann reveals the most powerful and effective ways to get the job done.", 14),
            new Book("ISBN-978-0-13-787090-5", "Core Java, Volume I: Advanced Features, 12th Edition", "Core Java is the leading no-nonsense tutorial and reference for experienced programmers who want to write robust Java code for real-world applications. Now, Core Java, Volume II: Advanced Features, Twelfth Edition, has been revised to cover the new features and enhancements in the Java 17 long-term support release. As always, all chapters have been completely updated, outdated material has been removed, and the new APIs are covered in detail.", 14)
    ));


    public List<LibraryUser> users = new ArrayList<>(Arrays.asList(
            new LibraryUser("Ebbe Lind", "EbbeLind@dayrep.com"),
            new LibraryUser("Kevin Lindqvist", "KevinLindqvist@armyspy.com")
    ));

    public List<Loan> loans = new ArrayList<>(
            Arrays.asList(
                    new Loan(users.get(0),books.get(2)),
                    new Loan(users.get(0),books.get(3)),

                    new Loan(users.get(1),books.get(0)),
                    new Loan(users.get(1),books.get(1)),
                    new Loan(users.get(1),books.get(2)),
                    new Loan(users.get(1),books.get(3))
            )
    );

    @BeforeEach
    void setUp() {
        books = books.stream()
                .map(em::persist)
                .collect(Collectors.toList());

        users = users.stream()
                .map(em::persist)
                .collect(Collectors.toList());

        loans = loans.stream()
                .map(em::persist)
                .collect(Collectors.toList());

        ebba = users.get(0);
        kevin = users.get(1);
        loan = loans.get(0);
    }

    @Test
    void findByLoanTaker() {
        List<Loan> lentByKevin = testObject.findByLoanTakerId(kevin.getId());

        assertEquals(4, lentByKevin.size());
    }

    @Test
    void findLoansByBookId() {
        List<Loan> byBookId = testObject.findByBookId(loan.getBook().getId());

        assertEquals(2, byBookId.size());
    }

    @Test
    void findByTerminatedStatus() {

        loan.setTerminated(Boolean.TRUE);


        List<Loan> byTerminated = testObject.findByTerminated(true);

        assertEquals(1, byTerminated.size());
    }
}