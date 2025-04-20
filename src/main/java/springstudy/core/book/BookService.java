package springstudy.core.book;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springstudy.core.book.dto.BookDto;
import springstudy.core.exception.ExceptionCode;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Book createBook(BookDto bookDto) {

        Optional<Book> findBook = bookRepository.findByTitleAndAuthor(bookDto.getTitle(), bookDto.getAuthor());

        if(findBook.isPresent()) {
            throw new IllegalArgumentException("이미 등록된 도서입니다.");
        }

        Book newBook = Book.builder()
                           .author(bookDto.getAuthor())
                           .quantity(bookDto.getQuantity())
                           .title(bookDto.getTitle())
                           .build();

        return bookRepository.save(newBook);
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
