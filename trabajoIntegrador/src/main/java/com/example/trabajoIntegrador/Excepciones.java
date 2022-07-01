package com.example.trabajoIntegrador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.apache.log4j.*;

@ControllerAdvice
public class Excepciones {

    private static final Logger logger = Logger.getLogger(Excepciones.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> errores(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity("Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}