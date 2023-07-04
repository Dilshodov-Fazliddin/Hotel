package com.example.wayne_hotel.config;

import com.example.wayne_hotel.exception.*;
import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<String>dataNotFoundExp(DataNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(value = {AuthenticationFailedException.class})
    public ResponseEntity<String>failedAuthorize(AuthenticationFailedException e){
        return ResponseEntity.status(401).body(e.getMessage());
    }

    @ExceptionHandler(value = {PSQLException.class})
    public ResponseEntity<String> PSQLExceptionHandler(
            PSQLException exception
    ){
        return ResponseEntity.status(400).body(exception.getMessage());
    }

    @ExceptionHandler(value = {RequestValidationException.class})
    private ResponseEntity<String>RequestValidationException(RequestValidationException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(value = {CaseEmptyException.class})
    private ResponseEntity<String>CaseEmptyException(CaseEmptyException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(value = {RentedRoomException.class})
    private ResponseEntity<String>RentedRoomException(RentedRoomException e){
        return ResponseEntity.status(400).body(e.getMessage());
    }
    @ExceptionHandler(value = {NotEnoughBalanceException.class})
    public ResponseEntity<String> notEnoughCredits(NotEnoughBalanceException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
