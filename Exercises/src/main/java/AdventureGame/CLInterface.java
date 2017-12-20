package AdventureGame;

import java.util.Scanner;

public class CLInterface {

    Scanner reader;

    public CLInterface() {

        reader = new Scanner(System.in);

    }

    public String playerInput(String prompt) {

        System.out.println(prompt);

        return reader.next();

    }

    public void setDelimiter(String delimiter) {
        reader.useDelimiter(delimiter);
    }
}
