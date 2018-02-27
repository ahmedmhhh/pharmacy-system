
package pharmacy.system;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationInput {
    public boolean EmailValidation(String Email){
        final String testEmail="[A-Za-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}";
        Pattern pattern = Pattern.compile(testEmail);
        Matcher matcher =pattern.matcher(Email);
        if(matcher.find())
            return true;
        else 
            return false;
    }
    
    public boolean PhoneValidation(String phone){
    final String testPhone="(011|012|015|010)([,\\s])?\\d{3}([,\\s])?\\d{3}"
                + "([,\\s])?\\d{2}";
        Pattern pattern = Pattern.compile(testPhone);
        Matcher matcher =pattern.matcher(phone);
        if(matcher.find())
            return true;
        else 
            return false;
    }
    public boolean PassValidation(String Pass){
    final String testPass="[A-Za-z0-9]{8,}";
        Pattern pattern = Pattern.compile(testPass);
        Matcher matcher =pattern.matcher(Pass);
        if(matcher.find())
            return true;
        else 
            return false;
    } 
}
