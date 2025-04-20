package springstudy.core.member;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import springstudy.core.exception.ExceptionCode;
import springstudy.core.member.dto.MemberDto;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Member join(MemberDto memberDto){
        Optional<Member> findMember = memberRepository.findByEmail(memberDto.getEmail());

        if(findMember.isPresent()){
            throw new IllegalArgumentException("이미 사용중인 이메일입니다.");
        }

        Member member = Member.builder()
                                .email(memberDto.getEmail())
                                .name(memberDto.getName())
                                .phoneNumber(memberDto.getPhoneNumber())
                                .pwd(memberDto.getPwd())
                                .build();

        return memberRepository.save(member);
    }

    public Member validateMember(String email, String pwd) {
        Member findMember = memberRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("회원을 찾을 수 없습니다."));

        if(!findMember.getPwd().equals(pwd)){
            throw new IllegalArgumentException("이메일 또는 비밀번호가 일치하지 않습니다.");
        }
        return findMember;
    }

    public void logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
