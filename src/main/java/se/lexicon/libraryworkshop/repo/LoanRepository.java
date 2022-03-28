package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import se.lexicon.libraryworkshop.model.Loan;

import java.util.List;
import java.util.Optional;

public interface LoanRepository extends JpaRepository<Loan, Long> {

    @Query("select b from book_loan b where upper(b.loanTaker.id) = upper(:id)")
    Optional<Loan> findByLoanTakerId(@Param("id") Long id);

    @Query("select b from book_loan b where upper(b.book.id) = upper(:id)")
    Optional<Loan> findByBookId(@Param("id") String id);

    @Query("select b from book_loan b where b.terminated = :terminated")
    List<Loan> findByTerminated(@Param("terminated") Boolean terminated);

}
