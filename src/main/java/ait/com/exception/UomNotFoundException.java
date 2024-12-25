package ait.com.exception;

public class UomNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8694551836270488038L;

	public UomNotFoundException() {
		
	}
	
	public UomNotFoundException(String msg) {
		super(msg);
	}
}
