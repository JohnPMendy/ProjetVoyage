package fr.projetjeu.exception;

public class CantPersistException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CantPersistException(String message) {
		super(message);
	}
}
