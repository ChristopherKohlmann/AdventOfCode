package dayone;

import java.util.ArrayList;

public class CalibrationValue {
    // Input as List of strings (done)
    // arrayValue strToInt ('firstIntDigit' + 'lastIntDigit')
    // sumOf Array[int] = Calibration sum als int

    private ArrayList<String> inputValues = null;

    private final String[] digitString = { "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

    public CalibrationValue(ArrayList<String> inputValues) {
        this.inputValues = inputValues;
    }

    private String getFirstDigitInLine(String lineToChange) {
        String firstDigit = "";
        int smallestIndex = lineToChange.length();
        for (String digit : digitString) {
            if(!lineToChange.contains(digit)){
                continue;
            }
            int indexOfDigitInLine = lineToChange.indexOf(digit);
            if (indexOfDigitInLine < smallestIndex) {
                smallestIndex = indexOfDigitInLine;
                firstDigit = digit;
            }
        }
        return firstDigit;
    }

    /**
     * prüfe ob die zeichenketten 'zero','one', 'two',...'nine' enthalten sind
     * prüfe welche enthaltene digit als erstes im value vorkommt
     * mit dieser digit dann replace first found auf den value ausführen
     * rufe methode mit neuem string nochmal auf
     * wenn keine gefunden wurden return the final string
     * 
     * @param lineToChange
     * @return
     */
    private String replaceDigitStringsWithDigit(String lineToChange) {
        String newLine = lineToChange;
        String firstDigitInLine = getFirstDigitInLine(lineToChange);
        if(firstDigitInLine == ""){
            return newLine;
        }
        String substitution = Integer.toString(getArabicSubstitutionDigit(firstDigitInLine));
        int insertIndex = newLine.indexOf(firstDigitInLine)+1;
        newLine = newLine.substring(0, insertIndex) + substitution + newLine.substring(insertIndex);
        return replaceDigitStringsWithDigit(newLine);
    }

    private int getArabicSubstitutionDigit(String digitToConvert) {
        int n=1;
        for (String digit : digitString){
            if (digit == digitToConvert){
                break;
            }
            n++;
        }
        return n;
    }

    private int getDigitFromString(String line) {
        String digits = "";

        for (char c : line.toCharArray()) {
            if (Character.isDigit(c)) {
                digits += c;
            }
        }

        if (digits.length() < 2) {
            digits += digits;
        }
        if (digits.length() > 2) {
            char firstDigit = digits.toCharArray()[0];
            char lastDigit = digits.toCharArray()[digits.length() - 1];
            digits = Character.toString(firstDigit) + Character.toString(lastDigit);
        }
        return Integer.parseInt(digits);
    }

    private ArrayList<Integer> digitSelector(ArrayList<String> input) {
        ArrayList<Integer> digits = new ArrayList<Integer>();

        if (inputValues == null) {
            System.err.println("Shit is empty!");
            return null;
        }

        for (String line : inputValues) {
            System.err.println(line);
            // Task Part Two
            System.err.println(replaceDigitStringsWithDigit(line)); 
            int digit = getDigitFromString(replaceDigitStringsWithDigit(line));
            System.err.println(digit);
            digits.add(digit);
        }
        return digits;
    }

    public void valueSum() {
        int result = digitSelector(this.inputValues).stream().mapToInt(Integer::intValue).sum();
        System.out.println("Fuck the result is: " + result);
    }

}