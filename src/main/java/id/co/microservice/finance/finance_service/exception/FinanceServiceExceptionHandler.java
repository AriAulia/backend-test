package id.co.microservice.finance.finance_service.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class FinanceServiceExceptionHandler {

    @ExceptionHandler(FinanceServiceException.class)
    public ResponseEntity<ErrorResponse> handleFinanceException(FinanceServiceException ex, HttpServletRequest req) {
        var status = ex.getStatus();
        var body = new ErrorResponse(status.value(), status.getReasonPhrase(), ex.getMessage());
        return ResponseEntity.status(status).body(body);
    }

}
