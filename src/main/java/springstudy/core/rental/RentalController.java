package springstudy.core.rental;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springstudy.core.rental.dto.RentalDto;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/rentals")
public class RentalController {
    private final RentalService rentalService;

    // 책 대여
    @PostMapping("/rent")
    public String rentBook(@RequestParam Long memberId, @RequestParam Long bookId, RedirectAttributes redirectAttributes) {

        try {
            rentalService.rentBook(memberId, bookId);
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
            //  일반적으로 Model은 리다이렉트 후에 데이터가 유지되지 않기 때문에, 리다이렉트 시 데이터를 전달하려면 RedirectAttributes를 사용해야 한다.
            // ex) addAttribute, addFlashAttribute
        }

        return "redirect:/books";
    }

    // 책 반납
    @PostMapping("/return")
    public String returnBook(@RequestParam Long memberId,
                             @RequestParam Long rentalId,
                             RedirectAttributes redirectAttributes){
        try{
            rentalService.returnBook(rentalId);
        } catch (Exception e){
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }

        redirectAttributes.addAttribute("memberId", memberId);
        return "redirect:/rentals/{memberId}/current";
    }

    // 현재 대출중인 도서내역
    @GetMapping("/{memberId}/current")
    public String getCurrentRentals(@PathVariable Long memberId, Model model) {
        List<RentalDto.RentalBookInfo> currentRentalDtoList = rentalService.getCurrentRentals(memberId).getCurrentRentalDtoList();
        model.addAttribute("currentRentalDtoList", currentRentalDtoList);
        return "rental/memberCurrentBooks";
    }

    // 전체 대출내역
    @GetMapping("/member/{memberId}")
    public RentalDto.GetAllRentalsResponse getAllRentals(@PathVariable Long memberId) {
        return rentalService.getAllRentals(memberId);
    }
}
