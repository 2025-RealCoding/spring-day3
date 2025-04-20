package springstudy.core.reponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import springstudy.core.exception.ExceptionCode;


/**
 * Response DTO 최상 클래스
 * @param <T>
 */
@Getter
@Setter
@Accessors(chain = true)    // 메서드 체이닝
@JsonInclude(JsonInclude.Include.NON_NULL)      // response Data null 제거
public class MyResponse<T> {

    private long code;
    private String message;
    private T data;
    public static <T> MyResponse<T> ok() {
        MyResponse<T> response = new MyResponse<>();
        response.setCode(ExceptionCode.SUCCESS.getCode());
        response.setMessage(ExceptionCode.SUCCESS.getMessage());
        return response;
    }

    public static <T> MyResponse<T> error(int code, String message) {
        MyResponse<T> response = new MyResponse<>();
        response.setCode(code);
        response.setMessage(message);
        return response;
    }
}
