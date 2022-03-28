package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.libraryworkshop.model.LibraryUser;

import java.util.Optional;

public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {

    @Query("select l from library_user l where upper(l.email) = upper(:email)")
    Optional<LibraryUser> findByEmailIgnoreCase(@Param("email") String email);

}
