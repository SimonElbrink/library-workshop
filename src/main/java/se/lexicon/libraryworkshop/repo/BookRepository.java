package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.libraryworkshop.model.Book;

public interface BookRepository extends JpaRepository<Book, String> {
}
