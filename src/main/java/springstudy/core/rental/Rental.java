package springstudy.core.rental;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import springstudy.core.book.Book;
import springstudy.core.member.Member;

import java.time.LocalDate;

@Entity
@Getter
public class Rental {

    public Rental() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Book book;

    @ManyToOne
    private Member member;

    private LocalDate rentDate;

    private LocalDate returnDate;

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookTitle(){
        return this.book.getTitle();
    }

    public String getBookAuthor(){
        return this.book.getAuthor();
    }

    @Builder
    public Rental(Long id, Book book, Member member, LocalDate rentDate, LocalDate returnDate){
        this.id=id;
        this.book=book;
        this.member=member;
        this.rentDate=rentDate;
        this.returnDate=returnDate;
    }
}
