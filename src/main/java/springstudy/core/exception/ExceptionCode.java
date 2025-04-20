package springstudy.core.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ExceptionCode {

    SUCCESS(1000, "성공", HttpStatus.OK),
    ACCOUNT_CREDENTIALS_EXCEPTION(2000, "이메일 또는 비밀번호가 일치하지 않습니다.", HttpStatus.UNAUTHORIZED),
    ACCOUNT_NOT_FOUND_EXCEPTION(2001, "회원을 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    ACCOUNT_EMAIL_ALREADY_USED_EXCEPTION(2002, "이미 사용중인 이메일입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_ALREADY_EXIST_EXCEPTION(3000, "이미 등록된 도서입니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    BOOK_NOT_FOUND_EXCEPTION(3001, "책을 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    INSUFFICIENT_BOOK_QUANTITY_EXCEPTION(3002, "책의 수량이 부족합니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    RENT_HISTORY_NOT_FOUND_EXCEPTION(3003, "대여 기록을 찾을 수 없습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    RENT_LIMIT_EXCEEDED_EXCEPTION(3004, "대출 가능 권수를 초과하였습니다.", HttpStatus.INTERNAL_SERVER_ERROR),
    RENTAL_ALREADY_COMPLETED_EXCEPTION(3005, "이미 반납 처리된 데이터입니다.", HttpStatus.INTERNAL_SERVER_ERROR),

    DATA_VALIDATION_EXCEPTION(4000, "데이터 유효성 오류가 발생하였습니다.", HttpStatus.BAD_REQUEST);

    private final int code;
    private final String message;
    private final HttpStatus httpStatus;
}
