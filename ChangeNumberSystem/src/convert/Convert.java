package convert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Convert {

    //Số bit biểu diễn
    private static final int bits = 32;

    public static String DecimalToBinary(long x) {
        if (x == 0) {
            return String.join("", Collections.nCopies(bits, "0"));
        }

        if (x > 0) {
            ArrayList<Integer> List = new ArrayList<>();
            while (x != 0) {
                List.add((int) x % 2);
                x /= 2;
            }
            while (List.size() < bits) {
                List.add(0);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = List.size() - 1; i >= 0; i--) {
                sb.append(List.get(i));
            }
            return sb.toString();
        }
        //negative 
        long abs = Math.abs(x);
        long[] bin = new long[bits];
        int i = bits - 1;
        while (abs > 0 && i >= 0) { 
            bin[i] = abs % 2;
            abs /= 2;
            i--;
        }

        //đảo bit
        for (int j = 0; j < bits; j++) {
            bin[j] = 1 - bin[j];
        }

        //cộng 1
        for (int j = bits - 1; j >= 0; j--) {
            if (bin[j] == 0) {
                bin[j] = 1;
                break;
            } else {
                bin[j] = 0;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < bin.length; j++) {
            sb.append(bin[j]);
        }
        return sb.toString();
    }

    public static long BinaryToDecimal(String input) {
        if(input.length() < bits){
            char signFir = input.charAt(0);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bits - input.length(); i++) {
                sb.append(signFir);
            }
            input = sb + input;
        }
        long result = 0;
        if (input.charAt(0) == '0') {
            for (int i = 0; i < input.length(); i++) {
                result = result * 2 + (input.charAt(i) - '0');
            }
            return result;
        }

        //chuyển hết về dạng số
        int[] bin = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            bin[i] = input.charAt(i) - '0';
        }

        //đảo bit
        for (int i = 0; i < bin.length; i++) {
            bin[i] = 1 - bin[i];
        }

        //cộng 1
        for (int j = bits - 1; j >= 0; j--) {
            if (bin[j] == 0) {
                bin[j] = 1;
                break;
            } else {
                bin[j] = 0;
            }
        }

        //chuyển về decimal
        for (int i = 0; i < bin.length; i++) {
            result = result * 2 + bin[i];
        }
        return -result;

    }

    public static String DecimalToHexa(long x) {
        if (x == 0) {
            return "0";
        }
        String hexDigit = "0123456789ABCDEF";
        ArrayList<Character> List = new ArrayList<>();
        while (x != 0) {
            List.add(hexDigit.charAt((int) x % 16));
            x /= 16;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = List.size() - 1; i >= 0; i--) {
            sb.append(List.get(i));
        }
        return sb.toString();
    }

    public static long HexadecimalToDecimal(String input) {
        long result = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            int value = (c >= '0' && c <= '9') ? (c - '0') : (c - 'A' + 10);
            result = result * 16 + value;
        }
        return result;
    }
}
/*
Các trường hợp Bi - Hex hay Hex - Bi
ta sẽ chuyển thông qua trung gian là decimal
Từ Binary -> Decimal -> Hexadecimal
Từ Hexadecimal -> Decimal -> Binary
*/
