

import com.swcguild.ConsoleIO;
import java.util.Arrays;
import java.util.Random;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class Hangman implements Game {

    public void run() {
        
        ConsoleIO con = new ConsoleIO();

        StringBuilder builder = new StringBuilder();
        Random r = new Random();
        
       

        boolean done = false;

        String[] word = {"develop", "console", "computer", "software", "snarky", "random", "hardly"};

        while (!done) {
            int n = r.nextInt(word.length);

            String chosenWord = word[n];

            String[] wordArray = chosenWord.split("");

            String misses = "";

            String answer = "";

            String[] dashes;
            dashes = new String[chosenWord.length()];

            for (int k = 0; k < chosenWord.length(); k++) {
                dashes[k] = "_";
            }

            int tries = (chosenWord.length()) * 2;

            while (tries > 0) {
                con.printStr("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                con.printStr("");
                System.out.print("Word:     ");
                for (int j = 0; j < dashes.length; j++) {
                    System.out.print(dashes[j] + " ");
                }
                con.printStr("\n");
                con.printStr("Misses:   " + misses);
                con.printStr("");
                String guess = con.readSingleLetter("Guess:    ");
                con.printStr("");

                boolean guessCorrect = false;
                for (int i = 0; i < wordArray.length; i++) {
                    if (wordArray[i].equalsIgnoreCase(guess)) {
                        dashes[i] = guess;
                        guessCorrect = true;
                    }

                }

                if (guessCorrect) {
                    con.printStr("You guessed correctly!");
                } else {
                    misses = misses + guess;
                }

                answer = Arrays.toString(dashes).replace(",", "").replace("[", "").replace("]", "").trim();

                if (chosenWord.equals(answer.replaceAll("\\s", ""))) {
                    con.printStr("-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                    con.printStr("");
                    System.out.print("Word:     ");
                    for (int j = 0; j < dashes.length; j++) {
                        System.out.print(dashes[j] + " ");
                    }
                    con.printStr("\n");
                    con.printStr("Misses:   " + misses);
                    con.printStr("");
                    con.printStr("Great job!  You win!\n");
                    tries = 0;
                }

                tries--;
            }
            con.printStr("The word was: " + answer + "\n");
           // if (io.readYorN("Play again? [y/n]").equalsIgnoreCase("n")) {
                done = true;
            }
        
       con.printStr("GAME OVER");
    }
    

  

    @Override
    public String getName() {
        return"Hangman";
    }

}