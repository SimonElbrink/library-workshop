package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.libraryworkshop.model.LibraryUser;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {
}
