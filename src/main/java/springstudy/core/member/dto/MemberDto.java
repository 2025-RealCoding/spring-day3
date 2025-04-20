package springstudy.core.member.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class MemberDto {

    String email;
    String name;
    String phoneNumber;
    String pwd;

    public MemberDto(String email, String name, String phoneNumber, String pwd) {
        this.email = email;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.pwd = pwd;
    }
}
