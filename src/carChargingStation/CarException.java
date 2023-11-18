package carChargingStation;

public class CarException extends Exception{
	/**
	 * Creates Car Exception with message
	 * @param message
	 */
	public CarException(String message) {
        super(message);
    }
	
	/**
	 * Creates an Exception with a message and the cause of why the exception happened 
	 * @param message
	 * @param cause
	 */
	public CarException(String message, Throwable cause) {
        super(message, cause);
    }
}
