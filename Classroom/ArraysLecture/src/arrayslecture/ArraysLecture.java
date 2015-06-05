/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arrayslecture;

/**
 *
 * @author apprentice
 */
public class ArraysLecture {

    public static void main(String[] args) {
        // declaration
        int [] teamScores;
        //creation
        teamScores = new int [10];
        
        teamScores[0] = 2;
        teamScores[1] = 45;
        teamScores[2] = 8;
        teamScores[3] = 24;
        teamScores[4] = 99;        
        teamScores[5] = 23;
        teamScores[6] = 28;
        teamScores[7] = 88;
        teamScores[8] = 1;
        teamScores[9] = 42;
        
        //declare, instanciate, assigns values
                
       int [] testArray = {2,4,6,12,42};  
       
       //Use any literals as long as the type matches
       
       String [] testStrings = {"test","me","please"};
                
    int currentScores = teamScores[2];
    
    teamScores[4] = 109;
    
    for(int i = 0; i<teamScores.length; i++){
            System.out.println("Element ["+i+"]=" + teamScores[i]);
    }
     //enhanced for loop ---- only works with i++
    
    System.out.println("Example of enhanced for loop");
    for (int num:teamScores){
        
        System.out.println("element = " + num);
    }
        
        //TWO DIMENSIONAL ARRAYS (array in a array/Make a matrix)
        
        String [] [] cityTeamNames = {
            {"Cleveland","cavs","Indians","Browns"},
            {"Columbus","Bluejays","Buckeys"},   
            {"Pittsburgh","Steelers","Pirates","Pinguins"}
        };
  
                for (int i=0; i<cityTeamNames.length; i++){
                    for(int j =0; j<cityTeamNames[i].length; j++){
                        System.out.println(cityTeamNames[i][j] + ' ');
                    }
                
                }
                
        
        
    }  
        
    }
    
    }
    
    
    
}
