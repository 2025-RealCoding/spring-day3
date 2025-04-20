package springstudy.core.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import springstudy.core.exception.ExceptionCode;


@Entity
@Getter
public class Book {
    public Book() {}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private int quantity;

    @Builder
    public Book(Long id, String title, String author, int quantity) {
        this.id=id;
        this.title=title;
        this.author=author;
        this.quantity=quantity;
    }

    public void decreaseQuantity() {
        if (this.quantity <= 0) {
            throw new IllegalStateException("책의 수량이 부족합니다.");       // TODO : MyException으로 처리
        }
        this.quantity--;
    }

    public void increaseQuantity() {
        this.quantity++;
    }

}
