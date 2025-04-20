package springstudy.core.member;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Member {

    public Member() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;   //unique
    private String name;
    private String phoneNumber;
    private String pwd;

    @Builder
    public Member(String email, String name, String phoneNumber, String pwd) {
        this.email=email;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.pwd=pwd;
    }
}
