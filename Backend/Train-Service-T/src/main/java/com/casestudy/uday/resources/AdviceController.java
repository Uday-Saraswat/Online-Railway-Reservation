package com.casestudy.uday.resources;


import com.casestudy.uday.CustomException.CustomException;
import org.apache.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handelEmptyInput(CustomException customException){
        return new ResponseEntity<String>(customException.getErrMess(), null, HttpStatus.SC_BAD_REQUEST);
    }



}







