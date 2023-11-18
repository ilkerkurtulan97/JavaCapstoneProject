package carChargingStation;

import java.util.InputMismatchException;
import java.util.Scanner;
import Utils.LogHandler;


public class ChargingStationSimulation {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		/*
		 * A - Handling Multiple Exceptions
		 * 
		 * try - catch - finally block implementation below for multiple exception
		 * handling
		 */

		/*
		 * try block executes up until to encounter an exception
		 * 
		 * first get number of locations as integer from user as input if the entered
		 * number is less than or equal to 0 throw user-defined exception
		 * ChargingStationException with the corresponding exception message
		 * 
		 * second get number of cars as integer from user as input if the entered number
		 * is less than or equal to 0 throw user-defined exception
		 * ChargingStationException with the corresponding exception message
		 *
		 * if there is no exception so far execute the simulation
		 * 
		 */

		/*
		 * if there is an exception catch blocks handle according to the exception type
		 * 
		 * first catch block is for user-defined ChargingStationException handling it
		 * prints out the exception type with the corresponding message to warn the user
		 * the code terminates if it is encountered
		 * 
		 * second catch block is for user input mismatch exception handling (e.g. input
		 * as X) it specifically warns the user to enter only digits the code terminates
		 * if it is encountered
		 * 
		 * last catch block is for all exceptions that are not specifically handled
		 * beforehand it warns the user that an error exists the code terminates if it
		 * is encountered
		 */

		/*
		 * finally block is executed at the end whether an exception exists or not it
		 * closes the scanner object to keep resources
		 * 
		 * scanner close action could be implemented via try with resource statement at
		 * the beginning of try block
		 * 
		 * 
		 */

		try {
			System.out.print("Enter the number of charging locations: ");
			int numLocations = scanner.nextInt();

			// User-defined exception for unexpected user input entry for number of
			// locations

			if (numLocations <= 0) {
				throw new ChargingStationException("Number of charging locations must be greater than 0.");
			}

			ChargingStation chargingStation = new ChargingStation(numLocations);

			System.out.print("Enter the number of cars to charge: ");
			int numCars = scanner.nextInt();

			// User-defined exception for unexpected user input entry for number of cars

			if (numCars <= 0) {
				throw new ChargingStationException("Number of cars to charge must be greater than 0.");
			}

			for (int i = 0; i < numCars; i++) {
				System.out.println("Simulating charging for Car " + (i + 1));
				chargingStation.simulateCharging();
			}

			System.out.println("Charging simulation completed. Check charging_log.txt for details.");

			// Created log files for each section
			LogHandler.createLogFile("ChargingStation");
			LogHandler.createLogFile("ChargingStationSimulation");
			LogHandler.createLogFile("EnergyManagementSystem");

			// Move/rename log files for archiving
			LogHandler.moveLogFile("ChargingStation", "ChargingStation_Archive");
			LogHandler.moveLogFile("ChargingStationSimulation", "ChargingStationSimulation_Archive");
			LogHandler.moveLogFile("EnergyManagementSystem", "EnergyManagementSystem_Archive");

		} catch (ChargingStationException e) {
			System.err.println("Charging Station Exception: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.err.println("Input Mismatch Exception: " + "Please enter only digits !");
		} catch (Exception e) {
			System.err.println("An unexpected error occurred: " + e.getMessage());
		} finally {
			scanner.close();
			System.out.println("Scanner closed successfully !");
		}
	}
}
