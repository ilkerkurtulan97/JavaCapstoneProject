package carChargingStation;

public class ChargingStationException extends Exception {
	/*
	 *  A - Handling Multiple Exceptions
	 *  
	 *  User-defined exception class 
	 *  for ChargingStationException class 
	 */
	
    private static final long serialVersionUID = 1562126286491863548L;

	public ChargingStationException(String message) {
        super(message);
    }
}
