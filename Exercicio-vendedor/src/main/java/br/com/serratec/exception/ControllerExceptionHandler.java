package br.com.serratec.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<String> erros = new ArrayList<>();
		for (FieldError f : ex.getBindingResult().getFieldErrors()) {
			erros.add(f.getField() + ":" + f.getDefaultMessage());
		} 
		
		RespostaAosErros er = new RespostaAosErros(status.value(), "Existem Campos Inválidos",LocalDateTime.now(), erros);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		RespostaAosErros er = new RespostaAosErros(status.value(), "Campos inválidos foram inseridos, favor verificar",
				LocalDateTime.now(), null);
		return super.handleExceptionInternal(ex, er, headers, status, request);
	}
	
	@ExceptionHandler(EmailExcpetion.class)
	protected ResponseEntity<Object> handleEmailException(EmailExcpetion ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
	
		RespostaAosErros er = new RespostaAosErros(status.value(), "Email Invalido!",
				LocalDateTime.now(), null);
		return super.handleExceptionInternal(ex, er, headers, status, request);
		}
	
	
	//qualquer coisa dá pra reaproveitar esse código da aula passada aqui em cima!!!!
}
