package info.juliocnsouza.puzzles.vanhack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MorseCode {

    final static Map<String, String> MORSE = new HashMap<>();
    static {
        MORSE.put(".-","A");
        MORSE.put("-...","B");
        MORSE.put("-.-.","C");
        MORSE.put("-..","D");
        MORSE.put(".","E");
        MORSE.put("..-.","F");
        MORSE.put("--.","G");
        MORSE.put("....","H");
        MORSE.put("..","I");
        MORSE.put(".---","J");
        MORSE.put("-.-","K");
        MORSE.put(".-..","L");
        MORSE.put("--","M");
        MORSE.put("-.","N");
        MORSE.put("---","O");
        MORSE.put(".---.","P");
        MORSE.put("--.-","Q");
        MORSE.put(".-.","R");
        MORSE.put("...","S");
        MORSE.put("-","T");
        MORSE.put("..-","U");
        MORSE.put("...-","V");
        MORSE.put(".--","W");
        MORSE.put("-..-","X");
        MORSE.put("-.--","Y");
        MORSE.put("--..","Z");
        MORSE.put(".----","1");
        MORSE.put("..---","2");
        MORSE.put("...--","3");
        MORSE.put("....-","4");
        MORSE.put(".....","5");
        MORSE.put("-....","6");
        MORSE.put("--...","7");
        MORSE.put("---..","8");
        MORSE.put("----.","9");
        MORSE.put("-----","0");
        MORSE.put("--..--",",");
        MORSE.put(".-.-.-",".");
        MORSE.put("..--..","?");
    }


    public static void main(String[] args) {

        final Map<String, List<String>> opts = Map.of(
                ".", List.of("E"),
                "-", List.of("T"),
                "-.", List.of("N"),
                "...", List.of("S"),
                "..-", List.of("U"),
                "?", List.of("E", "T"),
                ".?", List.of("I", "A"),
                "?-?", List.of("R", "W", "G", "O")
        );
        opts.keySet()
                .stream().forEach(signals ->{
            final List<String> possibilities = possibilities(signals);
            System.out.println("\n\nPossibilities for " + signals + " matches?");
            final List<String> expected = opts.get(signals);
            final boolean matches = possibilities.equals(expected);
            System.out.println(matches);
            if (!matches){
                System.out.println("Expected:\n" + expected);
                System.out.println("\nGot:\n" + possibilities);
            }
        });

    }

    public static List<String> possibilities (String signals) {

        final boolean isSignalsValid = signals != null && !signals.isEmpty() && signals.length() <= 3;
        if (!isSignalsValid){
            return null;
        }

        List<String> possibilities = new ArrayList<>();

        if(signals.contains("?")){
            List<String> unknownPossibilities = new ArrayList<>();
            replaceQuestionMark(signals, unknownPossibilities);

            final List<String> possibleResults = unknownPossibilities.stream()
                    .map(unknownPossibility -> MORSE.get(unknownPossibility))
                    .filter(unknownPossibility -> unknownPossibility != null)
                    .collect(Collectors.toList());

            possibilities.addAll(possibleResults);
        }
        else{
            String signal = MORSE.get(signals);
            if (signal != null){
                possibilities.add(signal);
            }
        }
        return possibilities;
    }

    private static void replaceQuestionMark(String signal, List<String> unknownPossibilities){
        if (!signal.contains("?")){
            unknownPossibilities.add(signal);
        }else {
            replaceQuestionMark(signal.replaceFirst("\\?", "."), unknownPossibilities);
            replaceQuestionMark(signal.replaceFirst("\\?", "-"), unknownPossibilities);
        }
    }
}
