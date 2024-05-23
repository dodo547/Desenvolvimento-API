package com.serratec.br.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	//trataento p/ a maioria dos erros com o MethodArg not valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		//Modelo pronto pego das aulas anteriores, Entendi + ou - a lógica, importante é que funciona 
		List<String> erros = new ArrayList<>();
		for (FieldError f : ex.getBindingResult().getFieldErrors()) {
			erros.add(f.getField() + ":" + f.getDefaultMessage());
		}
																//Está numa forma genérica do tratamento de erro, idealmente só chegaremos nesse erro nas classes que fazemos validações!
		RespostaAosErros er = new RespostaAosErros(status.value(), "Existem campos inválidos", LocalDateTime.now(),
				erros);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}

	
}
