package springstudy.core.rental.dto;

import lombok.*;
import springstudy.core.rental.Rental;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class RentalDto {

    RentalDto() {}

    @Getter
    @Builder
    public static class GetAllRentalsResponse {
        private List<RentalInfo> rentalDtoList;

        public static GetAllRentalsResponse of(List<Rental> rentals) {
            List<RentalInfo> tempList = rentals.stream()
                    .map(rental -> RentalInfo.builder()
                            .id(rental.getId())
                            .memberId(rental.getMember().getId())
                            .bookId(rental.getBook().getId())
                            .rentDate(rental.getRentDate())
                            .returnDate(rental.getReturnDate())
                            .build())
                    .collect(Collectors.toList());

            return GetAllRentalsResponse.builder()
                    .rentalDtoList(tempList)
                    .build();
        }
    }

    @Getter
    @Builder
    public static class GetCurrentRentalsResponse {
        private List<RentalBookInfo> currentRentalDtoList;

        public static GetCurrentRentalsResponse of(List<Rental> rentals) {

            List<RentalBookInfo> tempList = rentals.stream()
                    .map(rental ->RentalBookInfo.builder()
                            .rentalId(rental.getId())
                            .memberId(rental.getMember().getId())
                            .bookId(rental.getBook().getId())
                            .bookTitle(rental.getBookTitle())
                            .bookAuthor(rental.getBookAuthor())
                            .rentDate(rental.getRentDate())
                            .returnDate(rental.getReturnDate())
                            .build())
                    .collect(Collectors.toList());

            return GetCurrentRentalsResponse.builder()
                    .currentRentalDtoList(tempList)
                    .build();
        }
    }


    @Getter
    @Builder
    public static class RentalInfo{
        private Long id;
        private Long memberId;
        private Long bookId;
        private LocalDate rentDate;
        private LocalDate returnDate;
    }

    @Getter
    @Builder
    public static class RentalBookInfo{
        private Long rentalId;
        private Long memberId;
        private Long bookId;
        private String bookTitle;
        private String bookAuthor;
        private LocalDate rentDate;
        private LocalDate returnDate;
    }
}
