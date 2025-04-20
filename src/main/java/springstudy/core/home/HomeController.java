package springstudy.core.home;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import springstudy.core.member.Member;

@Controller
public class HomeController {

    @GetMapping("/")
    public String getHomepage(HttpSession session, Model model) {

        Member member = (Member) session.getAttribute("currentMember");

        if (member != null) {
            model.addAttribute("memberName", member.getName());
            return "home/loginHome";
        }
        return "home/index";
    }
}
