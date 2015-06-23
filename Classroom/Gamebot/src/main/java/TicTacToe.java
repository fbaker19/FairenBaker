
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class TicTacToe implements Game {
    

    public void run() {

        char[][] board = new char[3][3];
        int choiceRow;
        int choiceCol;
        boolean winner = false;
        int spacesTaken = 1;
        String string="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Let's play Tic-Tac-Toe!");
        while (!winner && spacesTaken != 10) {
            spacesTaken++;
            if (spacesTaken % 2 == 0) 
            {
                System.out.println(" player X, Choose a row and column (0-2),(0-2)");
                choiceRow = sc.nextInt();
                choiceCol = sc.nextInt();
                board[choiceRow][choiceCol] = 'X';
            } 
            
            else 
            {
                System.out.println(" player O, Choose a row and column (0-2),(0-2)");
                choiceRow = sc.nextInt();
                choiceCol = sc.nextInt();
                board[choiceRow][choiceCol] = 'O';
            }
            
            for(int i = 0; i<board.length; i++){
                for (int j = 0; j<board[i].length; j++){
                    System.out.print(board[i][j]);
                }
            }
            
            }
            
            if (board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') // X top horizontal
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') // X middle horizontal
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') //X bottom horizontal
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') // O top horizontal
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') // O middle horizontal
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') // O bottom horizontal
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') // X Vertical Left
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') // X Vertical middle
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') // X Vertical Right
            {
                System.out.println("X Wins");
                winner=true;
            }
            ///////
            else if (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') // O Vertical Left
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') // O Vertical middle
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') // O Vertical Right
            {
                System.out.println("O Wins");
                winner=true;
            }
            //    ../......
            else if (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') // X diagonal from top left
            {
                System.out.println("X Wins");
                winner=true;
            }
            
            else if (board[2][0] == 'X' && board[1][1] == 'X' && board[0][2] == 'X') // X diagonal from bottom left
            {
                System.out.println("X Wins");
                winner=true;
            }
            //...........
            else if (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') // X diagonal from top left
            {
                System.out.println("O Wins");
                winner=true;
            }
            
            else if (board[2][0] == 'O' && board[1][1] == 'O' && board[0][2] == 'O') // X diagonal from bottom left
            {
                System.out.println("O Wins");
                winner=true;
            }
        }

  

    @Override
    public String getName() {
       return "TicTacToe";
    }

    }
    

