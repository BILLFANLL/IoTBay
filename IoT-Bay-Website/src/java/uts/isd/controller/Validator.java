
package uts.isd.controller;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;



public class Validator implements Serializable{ 


   private String emailPattern  = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
   private String namePattern = "([A-Z][a-z]+[\\s])+[A-Z][a-z]*";       
   private String passwordPattern = "[a-z0-9]{4,}";   
   private String phonePattern = "([0-9]{10})"; 
              
   public Validator(){    }       


   public boolean validate(String pattern, String input){       
      Pattern regEx = Pattern.compile(pattern);       
      Matcher match = regEx.matcher(input);       

      return match.matches(); 

   }       

 

   public boolean checkEmpty(String email, String password){       

      return  email.isEmpty() || password.isEmpty();   

   }

   
   public boolean validateEmail(String email){                       

      return validate(emailPattern,email);   

   }

       
   public boolean validateName(String name){

      return validate(namePattern,name); 

   }       
   

   public boolean validatePassword(String password){

      return validate(passwordPattern,password); 

   }          

   public boolean validatePhone(String phone){
     return validate(phonePattern,phone);
   }


   public void clear(HttpSession session){
        session.setAttribute("emailErr", "Enter email"); 
        session.setAttribute("passErr", "Enter password");
        session.setAttribute("existErr", "");
        session.setAttribute("nameErr", "Enter name");
    }
}
    
