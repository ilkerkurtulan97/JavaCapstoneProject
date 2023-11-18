package carChargingStation;

import java.io.IOException;
import java.util.Random;
import Utils.ExceptionHandler;

class ChargingStation{
    private int numLocations;
    private int[] occupied;
    private String[] energySources = {"Solar", "Wind", "Grid"};
    private int chargingTime = 10; // Charging time in minutes
    private int maxWaitTime = 5; // Maximum wait time in minutes

    public ChargingStation(int numLocations) {
        this.numLocations = numLocations;
        occupied = new int[numLocations];
    }

    public void simulateCharging() throws ChargingStationException {
        Random random = new Random();

        for (int i = 0; i < numLocations; i++) {
            if (occupied[i] == 0) {
                // Charge the car
                System.out.println("Car is charging at location " + i + " with " + energySources[i % energySources.length] + " energy source.");

                // Simulate weather conditions
                String weatherCondition = (random.nextBoolean()) ? "Sunny" : "Rainy";
                System.out.println("Weather Condition: " + weatherCondition);

                // Simulate energy source management
                manageEnergySource();

                // Release the charging station after charging
                occupied[i] = 1;
                
                try {
                	writeToFile("Charging log: Car charged at location " + i + " with " + energySources[i % energySources.length] +
                            " energy source in " + chargingTime + " minutes. Weather Condition: " + weatherCondition);
                }
                catch (Exception e) {
                	e.printStackTrace();
				}
                
                System.out.println("Car has finished charging at location " + i);

                if (allLocationsOccupied()) {
                    System.out.println("All charging locations are occupied. Ending simulation.");
                    return;
                }
            } else {
                // If all places are occupied, the car will wait for a certain time
                int waitTime = random.nextInt(maxWaitTime);
                System.out.println("Location " + i + " is occupied. Car is waiting for " + waitTime + " minutes.");
                
                try {
                writeToFile("Charging log: Car waiting at location " + i + " for " + waitTime + " minutes.");
                }
                catch (Exception e) {
                	e.printStackTrace();
				}
            }
        }
    }

    private boolean allLocationsOccupied() {
        for (int location : occupied) {
            if (location == 0) {
                return false;
            }
        }
        return true;
    }

    private void manageEnergySource() {
        // Simulate energy source management
        // You can add more sophisticated logic for energy source switching based on weather conditions, battery levels, etc.
        System.out.println("Managing energy sources...");
    }

    private void writeToFile(String message) {
    	
    	/*	A - Handling Multiple Exceptions
    	 * 
    	 *  try with resources implemented below along with exception handling
    	 * 	writer object of class FileWriter is closed at the end of the statement
    	 * 
    	 * 	if the file name argument of FileWriter constructor cannot be found or created
    	 * 	(e.g. if it is "" blank string as file name argument to the constructor
    	 * 	then IOException object is created 
    	 * 	its stack trace is printed out 
    	 * 
    	 * 	the code does not terminate since while attempting to write 
    	 * 	due to IOException the system attempts to close the writer (try with resource) 
    	 *  closing the file also generates IOException that will be suppressed 
    	 *  if the termination is definitely wanted 
    	 *  System.exit(1); line can be added in the catch block
    	 * 
    	 */

        /*	PART C: Resource Management -)
         * Inside the try block reading is done. However as soon as we exit the try block, resource automatically
         * closed. This happens due to implementing the AutoCloseable interface.
         */
    	
        try (ExceptionHandler exceptionHandler = new ExceptionHandler("charging_log.txt")) {
            exceptionHandler.writeData(message + "\n");
        }
        catch (NullPointerException e) {
        	System.out.println("Null Pointer Exception");
        	throw e;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}