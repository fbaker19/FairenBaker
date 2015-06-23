/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class App {
    public static void main(String[] args) {
        
        Colorable ball = new Ball();
        ball.setColor("purple");
        System.out.println("Start wearing " + ball.getColor());
        
        ((Debuggable)ball).displayError("It worked!");  //calls debuggable from main class (Ball)
       // Debuggable test = (Debuggable)ball; //test instantiates (Debuggable) Ball
        
        Debuggable test = (DebugLogging)ball; //Chain - DebugLogging extends Debuggable
        test.displayStatus("123 WIN");//casting works only in () ie (Debuggable)
        
        DebugLogging log = (DebugLogging)ball;
        log.logError("Logging some other error");
    }
 
}
