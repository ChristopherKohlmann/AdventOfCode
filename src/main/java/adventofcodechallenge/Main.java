package adventofcodechallenge;

import java.nio.file.Path;
import java.nio.file.Paths;
import dayone.CalibrationValue;

public class Main {

       public static void main(String[] args) {
        
        Path path = Paths.get("src/main/java/dayone/input.txt");
        //Path path = Paths.get("src/main/java/dayone/testInput.txt");

        if (!path.toFile().exists()) {
            System.err.println("File not found!");
            System.exit(1);
        }
        String input = path.toAbsolutePath().toString();

        InputReader ir = new InputReader(input);
        CalibrationValue cv = new CalibrationValue(
            ir.readInput());

        cv.valueSum(); 
    }



}