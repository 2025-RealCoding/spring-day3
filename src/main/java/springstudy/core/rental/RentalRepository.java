package springstudy.core.rental;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface RentalRepository {
    Optional<Rental> findById(Long rentalId);
    Rental save(Rental rental);
    long countByMemberIdAndReturnDateIsNull(Long memberId);
    List<Rental> findByMemberIdAndReturnDateIsNull(Long memberId);
    List<Rental> findAllByMember_Id(Long memberId);
}
