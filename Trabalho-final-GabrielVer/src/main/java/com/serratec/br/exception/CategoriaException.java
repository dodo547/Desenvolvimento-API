package com.serratec.br.exception;

import org.springframework.validation.BindException;

public class CategoriaException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CategoriaException(String msg) {
		super(msg);
	}

	public BindException getBindingResult() {
		// TODO Auto-generated method stub
		return null;
	}
}
