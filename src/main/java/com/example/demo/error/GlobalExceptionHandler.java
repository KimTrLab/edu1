package com.example.demo.error;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice   //Spring의 전역 예외 처리 및 전역 바인딩 설정
//@ControllerAdvice + @ResponseBody를 합친 것 
//@ControllerAdvice는 HTML 응답도 가능하지만, @RestControllerAdvice는 REST API용 JSON 응답에 최적화
public class GlobalExceptionHandler {

	
	//서비스 단에서 발생한 IllegalArgumentException 예외처리
	//IllegalArgumentException.class
    //IllegalArgumentException은 Java 표준 RuntimeException
    //호출하는 쪽에서 반드시 처리하지 않아도 됨
    //메시지를 통해 어떤 인자가 문제인지 알려줄 수 있음  throw new IllegalArgumentException("ID는 비어 있을 수 없습니다.");
    //사용용도   null 체크, 값 범위 체크, 포맷 검증 등  이번 프로젝트에서는 userservice에서 사용
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException e) {
        Map<String, String> error = new HashMap<>();
        error.put("error", e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }
    
    

 // 유효성 검증 실패 처리 (@Valid, @NotBlank 등)  
 // 데이터베이스에서 처리된 오류가 500번인데 그게 발생하면 이건 무용지물 
 // 컨트롤러에서 작업을해서 필요가 없어짐  
    /*
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException e) {
        Map<String, String> error = new HashMap<>();

        // 여러 개의 필드 에러 중 첫 번째만 사용
        String errorMessage = e.getBindingResult()
                               .getFieldErrors()
                               .stream()
                               .findFirst()
                               .map(fieldError -> fieldError.getDefaultMessage())
                               .orElse("잘못된 요청입니다.");

        error.put("error", errorMessage);
        return ResponseEntity.badRequest().body(error);
    }*/
    
// 데이터 베이스 작업 시 에러 처리
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDBConstraint(DataIntegrityViolationException ex) {
        Map<String, String> error = new HashMap<>();
        Throwable cause = ex.getCause();
        if (cause != null) {
            String msg = cause.getMessage();
            System.out.println(msg);
            if (msg.contains("CHK_USER_NAME")) {
                error.put("error", "이름은 2글자 이상");
            } else if (msg.contains("CHK_USER_EMAIL")) {
                error.put("error", "한글은 8글자 이상");
            } else {
                error.put("error", "데이터 제약 조건 위반");
            }
        } else {
            error.put("error", "데이터 처리 중 오류가 발생했습니다.");
        }


        return ResponseEntity.badRequest().body(error);
    }
}
