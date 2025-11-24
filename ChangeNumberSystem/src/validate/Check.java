package validate;
import java.util.regex.Pattern;

public class Check {
    public static String BINARY_VALID = "[01]+";
    public static String DECIMAL_VALID = "^-?[0-9]+";
    public static String HEXADECIMAL_VALID = "[0-9A-F]+";
    
    public static boolean checkInputBinary(String input){
        return Pattern.matches(BINARY_VALID, input);
    }
    
    public static boolean checkInputDecimal(String input){
        return Pattern.matches(DECIMAL_VALID, input);
    }
    
    public static boolean checkInputHexadecimal(String input){
        return Pattern.matches(HEXADECIMAL_VALID, input);
    }
}
