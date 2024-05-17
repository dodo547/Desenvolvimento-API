package br.com.serratec.exception;

public class NomeException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NomeException() {
		super("Nome Não pode ser Aceito!");
	}
	
	
}
