package AdvancedExercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Anagrams {

    public HashMap<String, ArrayList<String>> createHashMap(ArrayList<String> wordList) {

        HashMap<String, ArrayList<String>> anagramsMap = new HashMap<String, ArrayList<String>>();

        WordSort ws = new WordSort();

        for (String w : wordList) {
            String sorted = ws.sortWord(w);
            if (!anagramsMap.containsKey(sorted)) {
                anagramsMap.put(sorted, new ArrayList<>());
            }
            anagramsMap.get(sorted).add(w);
        }
        return anagramsMap;
    }

    public String mostAnagrams(HashMap<String, ArrayList<String>> anagramsMap) {

        int max = 0;
        String bestWord = "";
        int wordLength = 0;

        for (Map.Entry<String, ArrayList<String>> entry : anagramsMap.entrySet()) {
            int noOfAnagrams = entry.getValue().size();
            if (noOfAnagrams > max) {
                max = noOfAnagrams;
                bestWord = entry.getKey();
                wordLength = bestWord.length();
            } else if (noOfAnagrams == max) {
                if (entry.getKey().length() > wordLength) {
                    max = noOfAnagrams;
                    bestWord = entry.getKey();
                    wordLength = bestWord.length();
                } else {
                    bestWord += "; " + entry.getKey();
                }
            }
        }

        return bestWord;
    }

    public String anagramSetToSring(ArrayList<String> anagramSet) {


        return "";
    }
}
