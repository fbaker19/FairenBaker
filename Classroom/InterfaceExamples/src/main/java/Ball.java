/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author apprentice
 */
public class Ball implements Colorable,  DebugLogging {///implent all abstract methods
private String color;

    @Override
    public void setColor(String color) {
        this.color = color;
        
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void displayStatus(String id) {
        System.out.println("Our status is "+ id);    }

    @Override
    public void displayError(String error) {
        System.out.println("Error: " +error);
    }

    @Override
    public void logStatus(String status) {
        System.out.println("Logging status: "+status);
    }

    @Override
    public void logError(String error) {
        System.out.println("Logging error "+error);
    }
    
}
