package ait.com.exception;

public class PurchesProductNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PurchesProductNotFoundException() {

	}

	public PurchesProductNotFoundException(String msg) {
		super(msg);
	}
}
