package dayone;

import java.util.ArrayList;

public class CalibrationValue{
    // Input as List of strings (done)
    // arrayValue strToInt ('firstIntDigit' + 'lastIntDigit')
    // sumOf Array[int] = Calibration sum als int

    private ArrayList<String> inputValues = null;
    
    public CalibrationValue(ArrayList<String> inputValues){
        this.inputValues = inputValues;
    }

    /**
     * prüfe ob die zeichenketten 'zero','one', 'two',...'nine' enthalten sind
     * wenn eine enthalten ist replace all found with correct digit
     * rufe funktion mit neuem string nochmal auf
     * wenn keine gefunden wurden return the final string
     * @param line
     * @return
     */
    private String replaceStringWithDigit(String writtenDigit, String line){
        String newLine = "";
        String[] digits = {"zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        int selectedDigit = findIndex(digits, writtenDigit);
        if(line.contains(writtenDigit)){
            newLine = line.replaceAll(writtenDigit, Integer.toString(selectedDigit));
        }
        return newLine;
    }

    private int getDigitFromString(String line){
        String digits = "";
        
        for (char c : line.toCharArray()){
            if (Character.isDigit(c)){
                digits += c;
            }
        }

        if(digits.length() < 2){
            digits += digits;
        }
        if(digits.length()>2){
            char firstDigit = digits.toCharArray()[0];
            char lastDigit = digits.toCharArray()[digits.length()-1];
            digits = Character.toString(firstDigit) + Character.toString(lastDigit);
        }
        return Integer.parseInt(digits);
    }

    private ArrayList<Integer> digitSelector(ArrayList<String> input){
        ArrayList<Integer> digits = new ArrayList<Integer>();

        if (inputValues == null){
            System.err.println("SHit is empty!");
            return null;
        }

        for (String line : inputValues){
            digits.add(getDigitFromString(line));
        }

        return digits;
    }

    public void valueSum() {
        int result = digitSelector(this.inputValues).stream().mapToInt(Integer::intValue).sum();
        System.out.println("Fuck the result is: " + result);
    }

    

}