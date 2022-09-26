package fr.projetjeu.exception;

public class InvalidEntityException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidEntityException(String message) {
		super(message);
	}
}
