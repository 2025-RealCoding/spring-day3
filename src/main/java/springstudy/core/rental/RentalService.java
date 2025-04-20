package springstudy.core.rental;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springstudy.core.book.Book;
import springstudy.core.book.BookRepository;
import springstudy.core.member.Member;
import springstudy.core.member.MemberRepository;
import springstudy.core.rental.dto.RentalDto;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class RentalService {

    private final MemberRepository memberRepository;
    private final RentalRepository rentalRepository;
    private final BookRepository bookRepository;
    private final int MAX_BORROW_LIMIT = 3;

    public RentalDto.GetAllRentalsResponse getAllRentals(Long memberId) {
        return null;
    }

    @Transactional
    public Rental rentBook(Long memberId, Long bookId) {
        return null;
    }

    @Transactional
    public Rental returnBook(Long rentalId) {
        return null;
    }

    public RentalDto.GetCurrentRentalsResponse getCurrentRentals(Long memberId) {
        return null;
    }

}
