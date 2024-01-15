package adventofcodechallenge;

import java.nio.file.Path;
import java.nio.file.Paths;
import dayone.CalibrationValue;
import daytwo.GameValidation;

public class Main {

    public static void main(String[] args) {

        

        //solveDayOne();

        solveDayTwo();
    }

    private static void solveDayTwo() {
        //Path path = Paths.get("src/main/java/daytwo/testinputdatwo.txt");
        Path path = Paths.get("src/main/java/daytwo/inputdaytwo.txt");
        if (!path.toFile().exists()) {
            System.err.println("File not found!");
            System.exit(1);
        }
        String input = path.toAbsolutePath().toString();

        daytwo.InputReader ir = new daytwo.InputReader(input);

        GameValidation gValidation = new GameValidation(ir.readInput());

        System.out.println(gValidation.sumOfGames());
    }

    private static void solveDayOne() {
        Path path = Paths.get("src/main/java/dayone/input.txt");
        // Path path = Paths.get("src/main/java/dayone/testInput.txt");
        if (!path.toFile().exists()) {
            System.err.println("File not found!");
            System.exit(1);
        }
        String input = path.toAbsolutePath().toString();

        dayone.InputReader ir = new dayone.InputReader(input);
        CalibrationValue cv = new CalibrationValue(
                ir.readInput());

        cv.valueSum();
    }

}