package AdvancedExercises;

import IntermediateExercises.FileWorker;
import java.util.ArrayList;
import java.util.HashMap;

public class HashmapsAnagrams {

    public HashmapsAnagrams() {

        ArrayList<String> wordList = readWordList();
        
        Anagrams anagrams = new Anagrams();
        HashMap<String, ArrayList<String>> anagramMap = anagrams.createHashMap(wordList);
        String bestWord = anagrams.mostAnagrams(anagramMap);

        System.out.println(anagrams.anagramSetToString(bestWord, anagramMap.get(bestWord)));

    }

    public static void main(String[] args) {
        HashmapsAnagrams ha = new HashmapsAnagrams();
    }

    public ArrayList<String> readWordList() {

        FileWorker fw = new FileWorker();

        String filename = "C:\\Users\\Admin\\JavaExercises\\Exercises\\WordList.txt";

        ArrayList<String> wordList = fw.fileReader(filename);

        return wordList;
    }

}
