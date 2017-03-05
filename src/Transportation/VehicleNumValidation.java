/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transportation;

import javax.swing.JTextField;

/**
 *
 * @author Dasuni Anupama
 */
public class VehicleNumValidation {
     String vehicleNumber;
    boolean correctType = false;
    boolean result = false;
    
    public  VehicleNumValidation(JTextField vehicleNumber){
    
        this.vehicleNumber=vehicleNumber.getText();
        if(this.vehicleNumber.length() > 6)
        correctType = true;
    }
    
    public boolean isVehicle(){
     if(correctType){
        if(vehicleNumber.charAt(2) == '-' && vehicleNumber.substring(3).length() == 4){
            if( isLetter(vehicleNumber.substring(0, 2)))
                  if(isNumeric(vehicleNumber.substring(3,6)))
                      result = true;
                  else
                      result = false;    
            else
                result = false;  
        }
        else if(vehicleNumber.charAt(3) == '-'){
                if( isLetter(vehicleNumber.substring(0, 3)) && vehicleNumber.substring(4).length() == 4)
                  if(isNumeric(vehicleNumber.substring(4,7)))
                      result = true;
                  else
                      result = false; 
                else
                result = false;    
        }
        else
            result = false;
     }else
       result = false;  
       
     return result;
    }
    
   private boolean isNumeric(String number ){
       boolean check = true;
       for(int i=0;i<number.length();i++)
           if(!Character.isDigit(number.charAt(i))){
           check = false;
           return check;    
           }       
      return check; 
   }
   
   private boolean isLetter(String word){
       boolean check = true;
       for(int i=0;i<word.length();i++)
           if(!Character.isLetter(word.charAt(i))){
           check = false;
           return check;   
           }       
      return check; 
   }
    
}
