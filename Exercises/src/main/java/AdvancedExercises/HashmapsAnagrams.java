package AdvancedExercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HashmapsAnagrams {

    ArrayList<String> wordList;

    public HashmapsAnagrams() {

        wordList = readFile();

        for (String w : wordList) {
            System.out.println(w);
        }
    }

    public static void main(String[] args) {
        HashmapsAnagrams ha = new HashmapsAnagrams();

    }

    public ArrayList<String> readFile() {

        ArrayList<String> wordList = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            String filename = "C:\\Users\\Admin\\JavaExercises\\Exercises\\WordList.txt";

            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                wordList.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return wordList;
    }

}
