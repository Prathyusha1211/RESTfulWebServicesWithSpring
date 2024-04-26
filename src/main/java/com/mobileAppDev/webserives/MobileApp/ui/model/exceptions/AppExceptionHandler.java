package com.mobileAppDev.webserives.MobileApp.ui.model.exceptions;

import com.mobileAppDev.webserives.MobileApp.UserControllers.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
        String errorMsg = ex.getLocalizedMessage();
        if(errorMsg==null) errorMsg = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMsg);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR) ;
    }

    @ExceptionHandler(value={NullPointerException.class,UserServiceException.class})
    public ResponseEntity<Object> handleSpecificExceptions(Exception ex, WebRequest request){
        String errorMsg = ex.getLocalizedMessage();
        if(errorMsg==null) errorMsg = ex.toString();
        ErrorMessage errorMessage = new ErrorMessage(new Date(),errorMsg);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR) ;
    }



}
