package com.progresssoft.deals.handler;

import com.progresssoft.deals.dto.ErrorWrapper;
import com.progresssoft.deals.exception.DealAlreadyExistsException;
import com.progresssoft.deals.exception.DealNotFoundException;
import com.progresssoft.deals.exception.MissingOrInvalidMandatoryFieldsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class DealsDataWarehouseExceptionHandler {
    @ExceptionHandler(DealAlreadyExistsException.class)
    public ResponseEntity<ErrorWrapper> handleDealAlreadyExistsException(DealAlreadyExistsException e){
        log.error("Error in the request Exception", e);
        return new ResponseEntity<ErrorWrapper>(ErrorWrapper.builder().errorMessage(e.getMessage()).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DealNotFoundException.class)
    public ResponseEntity<ErrorWrapper> handleDealNotFoundException(DealNotFoundException e){
        log.error("Error in the request Exception", e);
        return new ResponseEntity<ErrorWrapper>(ErrorWrapper.builder().errorMessage(e.getMessage()).build(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MissingOrInvalidMandatoryFieldsException.class)
    public ResponseEntity<ErrorWrapper> handleMissingOrInvalidMandatoryFieldsException(MissingOrInvalidMandatoryFieldsException e){
        log.error("Error in the request Exception", e);
        return new ResponseEntity<ErrorWrapper>(ErrorWrapper.builder().errorMessage(e.getMessage()).build(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorWrapper> handleException(Exception e){
        log.error("Error in the request Exception", e);
        return new ResponseEntity<ErrorWrapper>(ErrorWrapper.builder().errorMessage(e.getMessage()).build(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
