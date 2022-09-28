package fr.projetjeu.exception;

public class InvalidArgsException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidArgsException(String message) {
		super(message);
	}
}
