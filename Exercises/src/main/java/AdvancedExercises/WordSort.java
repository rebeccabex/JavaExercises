package AdvancedExercises;

import java.util.Arrays;

public class WordSort {


    public String sortWord(String word) {

        char[] letters = word.toLowerCase().toCharArray();

        Arrays.sort(letters);

        return new String(letters);

    }

}
