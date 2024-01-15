package daytwo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputReader {

    private String inputPath;

    public InputReader(String inputPath) {
        this.inputPath = inputPath;
    }

    public HashMap<Integer, List<Map<String, Integer>>> readInput() {
        HashMap<Integer, List<Map<String, Integer>>> result = new HashMap<Integer, List<Map<String, Integer>>>();
        // Map<GameID, Game>
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath))) {

            List<String> inputLines = br.lines().toList();
            int n =1;
            for (String eachStr : inputLines) {
                result.put(n, formatLineString(eachStr));
                n++;
            }

        } catch (IOException e) {
            // If result is used later and should be an empty list, no error would be thrown!
            // Thus the return should be set to null.
            result = null;
            System.err.println("Could not read File.");
            e.printStackTrace();
        }

        // Gehe jede einzelne input zeile durch:
        //  1. "Game [index] :" herausnehmen
        //   restlichen string unterteilen mit ";" als trenn-zeichen
        //      jedes string als jason format einlesen mit keys (red,green,blue) und anzahl als value
        // => die aufgeteilten jsons in übergordnete json einlesen mit game als key und string array jssons als value
        return result;
    /*
        Beispiel:
    json: {
        "1": [
            { Red: 1, Green: 2, Blue: 3},
           origInput -> Game 1: 1 green, 4 blue; 1 blue, 2 green, 1 red; 1 red, 1 green, 2 blue; 1 green, 1 red; 1 green; 1 green, 1 blue, 1 red
            { Red: 1, Green: 2, Blue: 3}
        ],
  Game-> "2": [ <- List
            { Red: 1, Green: 2, Blue: 3}, <- HashMap
            { Red: 1, Green: 2, Blue: 3}
        ]
    }

    */
    }

    private List<Map<String, Integer>> formatLineString(String eachStr) {
        String stringOfSets = eachStr.split(":")[1];
        String[] arrayOfSets = stringOfSets.split(";");
        List<Map<String, Integer>> game = new ArrayList<Map<String, Integer>>();
        for (String set : arrayOfSets) {
            Map<String, Integer> setMap = new HashMap<String, Integer>();
            String[] draws = set.split(",");
            for (String draw : draws){
                String[] keyValuePairs = draw.strip().split(" ");
                setMap.put(keyValuePairs[1], Integer.parseInt(keyValuePairs[0]) );
            }
            game.add(setMap);
        }
        return game;
    };
}
