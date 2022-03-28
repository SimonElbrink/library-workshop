package se.lexicon.libraryworkshop.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.libraryworkshop.model.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
