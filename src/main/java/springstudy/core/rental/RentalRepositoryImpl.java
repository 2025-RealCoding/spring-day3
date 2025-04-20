package springstudy.core.rental;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RentalRepositoryImpl implements RentalRepository{

    @Override
    public Optional<Rental> findById(Long rentalId) {
        return Optional.empty();
    }

    @Override
    public Rental save(Rental rental) {
        return null;
    }

    @Override
    public long countByMemberIdAndReturnDateIsNull(Long memberId) {
        return 0;
    }

    @Override
    public List<Rental> findByMemberIdAndReturnDateIsNull(Long memberId) {
        return null;
    }

    @Override
    public List<Rental> findAllByMember_Id(Long memberId) {
        return null;
    }
}
