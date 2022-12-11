package com.lz.gamestore.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lz.gamestore.services.exceptions.DataIntegrityException;
import com.lz.gamestore.services.exceptions.ObjNotFoundException;

import jakarta.servlet.ServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjNotFoundException.class)
	public ResponseEntity<DefaultError> objNotFoundException(ObjNotFoundException e, ServletRequest req){
		DefaultError n  = new DefaultError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(n);

	}
	
	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<DefaultError> dataIntegrityException(DataIntegrityException e, ServletRequest req){
		DefaultError n  = new DefaultError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(n);

	}


}
