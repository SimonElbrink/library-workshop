package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.libraryworkshop.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, String> {
    @Query("select b from book b where b.reserved = :reserved")
    List<Book> findByReserved(@Param("reserved") Boolean reserved);

    @Query("select b from book b where b.available = :available")
    List<Book> findByAvailable(@Param("available") Boolean available);

    @Query("select b from book b where upper(b.title) like upper(concat('%', :title, '%'))")
    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);



}
