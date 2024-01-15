package daytwo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GameValidation {

    private HashMap<Integer, List<Map<String, Integer>>> games;

    public GameValidation(HashMap<Integer, List<Map<String, Integer>>> games) {
        this.games = games;
    };

    public int sumOfGames() {
        int sum = 0;
        Iterator<Entry<Integer, List<Map<String, Integer>>>> it = this.games.entrySet().iterator();
        Map.Entry<Integer, List<Map<String, Integer>>> entry;
        while (it.hasNext()) {
            // https://stackoverflow.com/a/1066603
            entry = (Map.Entry<Integer, List<Map<String, Integer>>>) it.next();
            if (gameIsValid((List<Map<String, Integer>>) entry.getValue())) {
                sum += (int) entry.getKey();
            }
            it.remove();
        }
        return sum;
    }

    private boolean gameIsValid(List<Map<String, Integer>> value) {
        // (blue <= 14, green <= 13, red <= 12)
        for (Map<String, Integer> set : value) {
            int blue = 0;
            int red = 0;
            int green = 0;
            if(set.get("blue") != null){
                blue = set.get("blue");
            }
            if(set.get("red") != null){
                red = set.get("red");
            }
            if(set.get("green") != null){
                green = set.get("green");
            }
            if (blue != 0 && blue > 14) {
                return false;
            }
            if (red != 0 && red > 12) {
                return false;
            }
            if (green != 0 && green > 13) {
                return false;
            }
        }
        return true;
    }

    // Gehe einzelne games im input durch und mache: -> Methode einzelne validierung
    // validiere ob das game die restriktionen verletzt (blue <= 14, green <= 13,
    // red <= 12)
    // wenn game restriktionen erfüllt dann gebe die game id zurück
    // addiere alle game id's die restriktion erfüllen -> methode für die summation
    // (ruft einzel validierung auf)
}
