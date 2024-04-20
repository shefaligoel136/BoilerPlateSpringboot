package com.machinecoding.boilerplate.ControllerAdvice;

import com.machinecoding.boilerplate.dto.ExceptionDTO.ExceptionDTO;
import com.machinecoding.boilerplate.exceptions.EntityDoesNotExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {
    @ExceptionHandler(EntityDoesNotExists.class)
    public ResponseEntity<ExceptionDTO> handleEntityNotFoundException(EntityDoesNotExists entityDoesNotExists){
        ExceptionDTO exceptionDTO = new ExceptionDTO();
        exceptionDTO.setMessage(entityDoesNotExists.getMessage());

        return new ResponseEntity<>(exceptionDTO, HttpStatus.NOT_FOUND);
    }
}
