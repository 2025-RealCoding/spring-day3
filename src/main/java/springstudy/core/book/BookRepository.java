package springstudy.core.book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
     Optional<Book> findByTitleAndAuthor(String title, String author);
}
