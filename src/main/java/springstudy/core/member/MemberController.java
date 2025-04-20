package springstudy.core.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springstudy.core.member.dto.MemberDto;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    // 회원등록 화면
    @GetMapping("/join")
    public String joinForm() {
        return "member/joinMemberForm";
    }

    //회원등록
    @PostMapping("/join")
    public String join(MemberDto memberDto, Model model) {

        String viewPath;

        try {
            Member savedMember = memberService.join(memberDto);
            model.addAttribute("member",savedMember);
            viewPath = "member/member";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            viewPath = "member/joinMemberForm";
        }
        return viewPath;
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email, @RequestParam("pwd") String pwd, HttpSession session, Model model){

        String viewPath;

        try {
            Member member = memberService.validateMember(email, pwd);
            session.setAttribute("currentMember", member);      // session 추가
            model.addAttribute("memberName", member.getName());
            viewPath = "home/loginHome";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            viewPath = "home/index";
        }

        return viewPath;
        // Spring MVC에서 Model은 서버 내부에서 View를 렌더링할 때 데이터를 전달하기 위해 사용
        // 하지만 redirect:/는 클라이언트가 새로운 HTTP 요청을 보내도록 지시하는 것이므로, 기존의 서버 내부 데이터(Model)는 더이상 유효하지 않다
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        memberService.logout(request);
        return "redirect:/";
    }
}
