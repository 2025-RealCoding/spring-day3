package springstudy.core.book;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springstudy.core.book.dto.BookDto;
import springstudy.core.member.Member;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping("/new")
    public String createForm() {
        return "book/createBookForm";
    }

    @PostMapping("/new")
    public String register(BookDto bookDto, Model model) {

        String viewName;

        try {
            Book newBook = bookService.createBook(bookDto);
            model.addAttribute("book", newBook);
            viewName = "book/book";

        } catch (IllegalArgumentException e) {
            model.addAttribute("error", e.getMessage());
            viewName = "book/createBookForm";
        }

        return viewName;
    }

    @GetMapping
    public String getAllBooks(HttpSession session, Model model) {
        List<Book> books = bookService.getAllBooks();

        Member currentMember = (Member) session.getAttribute("currentMember");

        model.addAttribute("memberId", currentMember != null ? currentMember.getId() : null);
        model.addAttribute("books", books);
        return "book/books";
    }
}
