package com.yalco.estore.exception.handler;

import com.yalco.estore.exception.ElementNotFoundByIdException;
import com.yalco.estore.exception.response.CustomExceptionResponse;
import com.yalco.estore.exception.NoSuchResultBySearchingCriteriaException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = NoSuchResultBySearchingCriteriaException.class)
    protected ResponseEntity<Object> handleNoSuchResultBySearchingCriteriaException(NoSuchResultBySearchingCriteriaException exception,
                                                                                    WebRequest webRequest){
        CustomExceptionResponse exceptionResponse = createResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now().toString());
        return handleExceptionInternal(exception,exceptionResponse,new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }

    @ExceptionHandler(value = ElementNotFoundByIdException.class)
    protected ResponseEntity<Object> handleIdNotFoundException(ElementNotFoundByIdException exception, WebRequest webRequest){
        CustomExceptionResponse exceptionResponse = createResponse(HttpStatus.BAD_REQUEST, exception.getMessage(), LocalDateTime.now().toString());
        return handleExceptionInternal(exception,exceptionResponse,new HttpHeaders(),HttpStatus.BAD_REQUEST,webRequest);
    }
    CustomExceptionResponse createResponse(HttpStatus status, String exceptionMessage, String timestamp){
        CustomExceptionResponse exceptionResponse = new CustomExceptionResponse();
        exceptionResponse.setStatus(status.value());
        exceptionResponse.setError(status.getReasonPhrase());
        exceptionResponse.setMessage(exceptionMessage);
        exceptionResponse.setTimestamp(timestamp);
        return exceptionResponse;
    }
}
