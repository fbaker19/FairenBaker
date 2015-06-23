
import com.swcguild.ConsoleIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author apprentice
 */
public class GameBot {

    public static void main(String[] args) {

        ConsoleIO con = new ConsoleIO();

        Game lucky7s = new LuckySevensRefactored();
        Game rps = new RPSRefactored();
        Game ttt = new TicTacToe();
        Game hangman = new Hangman();

        boolean keepGoing = true;
        Game[] allGames = {lucky7s, rps, ttt, hangman};

        while (keepGoing) {
            con.printStr("Welcome to Game Bot! Please select a game!");

            int i = 1;

            for (Game g : allGames) {
                con.printStr("please choose " + i + " to play " +g.getName());
           i++;
            }
            int menuSelection = con.readIntRange("please choose " + i + "to exit:", 1, i);

            if (menuSelection == i) {
                keepGoing = false;
            } else {
                allGames[menuSelection -1].run();

            }
        }

    }

}
