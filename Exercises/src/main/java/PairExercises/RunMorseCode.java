package PairExercises;



import javafx.scene.paint.Stop;

import java.sql.ClientInfoStatus;
import java.util.Scanner;

public class RunMorseCode extends MorseCode {

    MorseCode codeObject = new MorseCode();

    public RunMorseCode() {
        boolean running = true;
        String stop = "Quit";

        while (running) {

            Scanner scanner = new Scanner(System.in);
            System.out.println(" Enter Letters ");
            // upper and lower case are okay!
            String word = scanner.next().toUpperCase();
            // stop appication if Quit in entered
            if (word.equalsIgnoreCase(stop)) {
                running = false;
            } else { // if quit is not entered do this

                for (int i = 0; i < word.length(); i++) {
                    if (codeObject.codeHash.containsKey(word.substring(i, i + 1))) {
                        String symbols = codeObject.getCodeHash().get(word.substring(i, i + 1));
                        System.out.println(symbols);
                    } else {
                        System.out.println(idiotProof());
                    }

                }
            }
        }

    }

    public String idiotProof() {

        String notaLetter = "Enter a valid Letter";
        return notaLetter;

    }









}
