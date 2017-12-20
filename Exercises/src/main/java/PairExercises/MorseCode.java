package PairExercises;

import java.util.HashMap;

public class MorseCode {
    HashMap <String, String> codeHash;

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

    }

    public static void main(String[] args) {

            RunMorseCode runObject = new RunMorseCode();









    }

    public HashMap<String, String> getCodeHash() {
        // list of letters that equal morse code
        return codeHash;
    }

}
