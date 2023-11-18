package carChargingStation;

public class Car {
	private int id;
	private int chargingDuration;
	
	/**
	 * Create a new Car with id and charging duration
	 * 
	 * @param id 					unique id 
	 * @param chargingDuration		value of charging duration
	 */
	public Car(int id, int chargingDuration) {
		this.id = id;
		this.chargingDuration = chargingDuration;
	}
	
	/**
	 * Returns the id of the car
	 * @return id as int
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Returns the charging duration fo the car
	 * 
	 * @return chargingDuration as int
	 */
	public int getChargingDuration() {
		return chargingDuration;
	}
}
