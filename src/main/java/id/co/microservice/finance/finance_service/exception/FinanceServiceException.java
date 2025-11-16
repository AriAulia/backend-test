package id.co.microservice.finance.finance_service.exception;

import org.springframework.http.HttpStatus;

public class FinanceServiceException extends RuntimeException {
    private final HttpStatus status;

    public FinanceServiceException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public FinanceServiceException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public FinanceServiceException(HttpStatus status) {
        this(status.getReasonPhrase(), status);
    }

    public HttpStatus getStatus() {
        return status;
    }
}
