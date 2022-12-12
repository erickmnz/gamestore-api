package com.lz.gamestore.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DefaultError> validationError(MethodArgumentNotValidException e, ServletRequest req){
		ValidationError n  = new ValidationError(System.currentTimeMillis(), HttpStatus.BAD_REQUEST.value(), "Field error validation: ");
		for(FieldError fm: e.getBindingResult().getFieldErrors()) {
			n.addError(fm.getField(), fm.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(n);

	}


}
