package com.lz.gamestore.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends DefaultError{

	private List<FieldMessage> errors = new ArrayList<>();
	
	public ValidationError() {
		super();
	}

	public ValidationError(long time, Integer status, String msg) {
		super(time, status, msg);
	}

	public List<FieldMessage> getErrors(){
		return errors;
	}
	
	public void addError(String name, String message) {
		this.errors.add(new FieldMessage(name,message));
	}
}
