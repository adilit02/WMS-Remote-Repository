package ait.com.exception;

public class ShippmentNotFoundException  extends RuntimeException{
	private static final long serialVersionUID = 1L;
	ShippmentNotFoundException()
	{
		
	}
	public ShippmentNotFoundException(String msg){
		super(msg);
		
		
		
	}
	
}