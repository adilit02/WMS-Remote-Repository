package ait.com.exception;


public class OrderNotFoundException extends RuntimeException{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8694551836270488038L;

	public OrderNotFoundException() {
		
	}
	
	public OrderNotFoundException(String msg) {
		super(msg);
	}
}
