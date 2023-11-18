package Utils;

import java.io.FileWriter;
import java.io.IOException;

// PART: C
//-----------------------------------------------------------------
//This is our exception handling class. Here we implement Autocloseable
// interface for successfully closing the file.
public class ExceptionHandler implements AutoCloseable{
	private FileWriter fileWriter;

    //Constructor
    public ExceptionHandler(String fileName) throws IOException {
        // Open the file for writing
        try {
            fileWriter = new FileWriter(fileName);
        } catch (IOException | NullPointerException e) {
            // Handling both IOException and NullpointerException
            System.out.println("Error opening the file: " + e.getMessage());
            throw e;
        }
    }

    // Method to write data to the file
    public void writeData(String data) throws IOException {
        fileWriter.write(data);
    }

    //Necessary overriding for Autoclosable interface.
    @Override
    public void close() throws IOException {
    	/*
		 * Here when we are dealing with our resources we can handle
		 * text file closing, database related operations, network connections
		 * etc...
		 */
        if (fileWriter != null) {
            fileWriter.close();
        }
    }
}
