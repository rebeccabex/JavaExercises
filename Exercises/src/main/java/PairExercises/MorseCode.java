package PairExercises;

import java.util.HashMap;

public class MorseCode {
    HashMap <String, String> codeHash;
    HashMap <String, String> codeHashMorsetoLetter;

    public MorseCode() {
        // Hashmap of strings representing ex a = ..-...
        codeHash = new HashMap ();

        codeHash.put("A",".-");
        codeHash.put("B","-...");
        codeHash.put("C","-.-.");
        codeHash.put("D","-..");
        codeHash.put("E",".");
        codeHash.put("F","..-.");
        codeHash.put("G","--.");
        codeHash.put("H","....");
        codeHash.put("I","..");
        codeHash.put("J",".---");
        codeHash.put("K","-.-");
        codeHash.put("L",".-.-");
        codeHash.put("M","--");
        codeHash.put("N","-.");
        codeHash.put("O","---");
        codeHash.put("P",".--.");
        codeHash.put("Q","--.-");
        codeHash.put("R", ".-.");
        codeHash.put("S","...");
        codeHash.put("T","-");
        codeHash.put("U","..-");
        codeHash.put("V","...-");
        codeHash.put("W",".--");
        codeHash.put("X","-..-");
        codeHash.put("Y","-.--");
        codeHash.put("Z","--..");
        codeHash.put("1",".----");
        codeHash.put("2","..---");
        codeHash.put("3","...--");
        codeHash.put("4","....-");
        codeHash.put("5",".....");
        codeHash.put("6","-....");
        codeHash.put("7","--...");
        codeHash.put("8","---..");
        codeHash.put("9","----.");
        codeHash.put("0","-----");
        codeHash.put(" ", "/");

        codeHashMorsetoLetter = new HashMap ();


        codeHashMorsetoLetter.put(".-", "A");
        codeHashMorsetoLetter.put("-...", "B");
        codeHashMorsetoLetter.put("-.-.", "C");
        codeHashMorsetoLetter.put("-..", "D");
        codeHashMorsetoLetter.put(".", "E");
        codeHashMorsetoLetter.put("..-.", "F");
        codeHashMorsetoLetter.put("--.", "G");
        codeHashMorsetoLetter.put("....", "H");
        codeHashMorsetoLetter.put("..", "I");
        codeHashMorsetoLetter.put(".---", "J");
        codeHashMorsetoLetter.put("-.-", "K");
        codeHashMorsetoLetter.put(".-.-", "L");
        codeHashMorsetoLetter.put("--", "M");
        codeHashMorsetoLetter.put("-.", "N");
        codeHashMorsetoLetter.put("---", "O");
        codeHashMorsetoLetter.put(".--.", "P");
        codeHashMorsetoLetter.put("--.-", "Q");
        codeHashMorsetoLetter.put(".-.", "R");
        codeHashMorsetoLetter.put("...", "S");
        codeHashMorsetoLetter.put("-", "T");
        codeHashMorsetoLetter.put("..-", "U");
        codeHashMorsetoLetter.put("...-", "V");
        codeHashMorsetoLetter.put(".--", "W");
        codeHashMorsetoLetter.put("-..-", "X");
        codeHashMorsetoLetter.put("-.--", "Y");
        codeHashMorsetoLetter.put("--..", "Z");
        codeHashMorsetoLetter.put(".----", "1");
        codeHashMorsetoLetter.put("..---", "2");
        codeHashMorsetoLetter.put("...--", "3");
        codeHashMorsetoLetter.put("....-", "4");
        codeHashMorsetoLetter.put(".....", "5");
        codeHashMorsetoLetter.put("-....", "6");
        codeHashMorsetoLetter.put("--...", "7");
        codeHashMorsetoLetter.put("---..", "8");
        codeHashMorsetoLetter.put("----.", "9");
        codeHashMorsetoLetter.put("-----", "0");
        codeHashMorsetoLetter.put("/", " ");

    }

    public static void main(String[] args) {

            RunMorseCode runObject = new RunMorseCode();









    }

    public HashMap<String, String> getCodeHashMorsetoLetter() {
        return codeHashMorsetoLetter;
    }

    public HashMap<String, String> getCodeHash() {
        // list of letters that equal morse code
        return codeHash;
    }

}
