/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EmployeeManagement;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author isuru
 */
public class ValidationEmployeeManagement {
    
    public static boolean chkNic(String nic){
        if(nic.length() != 10)
            return true;
        if(nic.charAt(9) != 'V')
            return true;
        else if(chkNum(nic.substring(0,9)))
            return true;
        else
            return false;
    }
    
    public static boolean chkNum(String str){
        for(char c : str.toCharArray()){
            if(!Character.isDigit(c))
                return true;
        }
        return false;
    }
    
    public static boolean chkEpf(String epf){
        if(epf.length() != 5 && chkNum(epf))
            return true;

        else
            return false;
    }
    
    public static boolean isValidEmailAddress(String email) {
   boolean result = true;
   try {
      InternetAddress emailAddr = new InternetAddress(email);
      emailAddr.validate();
   } catch (AddressException ex) {
      result = false;
   }
   return result;
}
    
    public static boolean checkNIC(String nic) {
       
        if ((nic.length() == 10)) 
        {
            if ((nic.charAt(9) == 'V') || (nic.charAt(9) == 'v')) {
                if (nic.trim().matches("^[0-9]{9}[vVxX]$")) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public static boolean checkPhone(String phone) {
       
        if ((phone.length() == 10)) 
        {

                if (phone.trim().matches("^[0-9]{9}[xX]$")) {
                    return true;
                } else {
                    return false;
                }
             

            
        } else {
            return false;
        }
    }
    
  /*  public static boolean chkEpf(String epf) {

        String regex = "^(\\d{5})$";
        if (epf.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }*/
    
}
