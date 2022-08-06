package com.marketkyke.catalogo.exception;

import com.marketkyke.catalogo.dto.ErrorDTO;
import com.marketkyke.catalogo.enums.APIError;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(ResourceNotException.class)
    public ResponseEntity<ErrorDTO> resourceNotFound(ResourceNotException e, WebRequest request){
        return ResponseEntity.status(e.getStatus())
                .body(new ErrorDTO(e.getDescription(),e.getReasons()));
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,HttpHeaders headers,
                                                                  HttpStatus status, WebRequest request){
        List<String> reasons = new ArrayList<>();
        for(FieldError error:ex.getBindingResult().getFieldErrors()){
            reasons.add(String.format("%s - %s",error.getField(),error.getDefaultMessage()));
        }
        return ResponseEntity.status(APIError.VALIDATION_ERROR.getHttpStatus()).body(
                new ErrorDTO(APIError.VALIDATION_ERROR.getMessage(), reasons));
    }
}
