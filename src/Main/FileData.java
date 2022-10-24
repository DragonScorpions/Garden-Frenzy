package Main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Base class for classes that write to file
 * @author xande
 */
public abstract class FileData {
    /**
     * Saves the data to the specified file name
     * @param fileName 
     *        The file to be saved to
     */
    public void SaveToFile(String fileName) {
        try {
            Files.writeString(Paths.get(fileName), ToFileString());
        } catch (IOException e) {
            System.err.println("Could not write to file \"" + fileName + "\": " + e.getMessage());
        }
    }
    
    /**
     * Loads the data from the specified file name
     * @param fileName 
     *        The file to be loaded from
     */
    public void LoadFromFile(String fileName) {
        try {
            ParseFileString(Files.readString(Paths.get(fileName)));
        } catch(IOException e) {
            System.err.println("Could not read from file \"" + fileName + "\": " + e.getMessage());
        }
    }
    
    /**
     * Converts class data to a string to be written to a file
     * @return 
     *         The string to be saved
     */
    protected abstract String ToFileString();
    
    /**
     * Populates class data from the given string
     * @param data 
     *        The string to be loaded
     */
    protected abstract void ParseFileString(String data);
}
