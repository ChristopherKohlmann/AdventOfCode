package adventofcodechallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

    private String inputPath;

    public InputReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public ArrayList<String> readInput() {
        ArrayList<String> result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {

            List<String> inputLines = br.lines().toList();

            for (String eachStr : inputLines) {
                result.add(eachStr.strip());
            }

        } catch (IOException e) {
            // If result is used later and should be an empty list, no error would be thrown!
            // Thus the return should be set to null.
            result = null;
            System.err.println("Could not read File.");
            e.printStackTrace();
        }
        return result;
    };
}
