/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanexpressions;

/**
 *
 * @author apprentice
 */
public class DaysofTheWeek {
    public static void main(String[] args){
    
    int day = 6;
    String dayName=" ";
    
   if (day == 1) {
        dayName ="Monday";
}
else if(day ==2){
   dayName = "Tuesday";
}else if(day ==3){
    dayName = "Wednesday";
}else if(day ==4){
    dayName = "Thursday";
}else if(day ==5){
    dayName = "Friday";
}else if(day ==6){
    dayName = "Saturday";
}else if(day ==7){
    dayName = "Sunday";
}else{
    dayName="invalid day";
}
  

  System.out.println(dayName);   
   
   String dayName1 ="";
   
switch(day){
case 1: 
        dayName1 ="Monday";
break;

case 2:
   dayName1 = "Tuesday";
    break;
case 3:
    dayName1 = "Wednesday";
break;

case 4:
    dayName1 = "Thursday";
break;

case 5:
    dayName1 = "Friday";
break;

case 6:
    dayName1 = "Saturday";
break;

case 7:
    dayName1 = "Sunday";
break;

default:
    dayName1="invalid day";
break;

}
}
}
